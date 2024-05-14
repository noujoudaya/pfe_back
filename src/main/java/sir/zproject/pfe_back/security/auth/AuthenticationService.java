package sir.zproject.pfe_back.security.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.security.role.RoleRepository;
import sir.zproject.pfe_back.security.security.JwtService;
import sir.zproject.pfe_back.security.user.Token;
import sir.zproject.pfe_back.security.user.TokenRepository;
import sir.zproject.pfe_back.security.user.User;
import sir.zproject.pfe_back.security.user.UserRepository;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final EmailSenderService senderService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final EmployeDao employeRepository;
    @Value("${spring.application.mailing.frontend.activation-url}")
    private String activationUrl;

    private String password;

    public void register(RegistrationRequest request) throws Exception {
        // var userRole = roleRepository.findByName("USER")
        //        .orElseThrow(() -> new IllegalStateException("ROLE USER was not initialized"));

        this.password = request.getPassword();
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .login(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)
                .roles(List.of(roleRepository.findByName(request.getRole().getName())))
                .build();
        userRepository.save(user);
        sendValidationEmail(user);
    }

    private ResponseEntity sendValidationEmail(User user) throws Exception {
        var newToken = generateAndSaveActivationToken(user);
        senderService.sendMail(user, newToken);
        return ResponseEntity.ok("email sent");
    }

    private String generateAndSaveActivationToken(User user) {
        String generatedToken = generateActivationCode(6);
        var token = Token.builder()
                .token(generatedToken)
                .createdDate(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);
        return generatedToken;
    }

    private String generateActivationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }
        return codeBuilder.toString();
    }

    public void activateAccount(String token) throws Exception {
        Token savedToken = tokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException("token not found"));
        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendValidationEmail(savedToken.getUser());
            throw new RuntimeException(" Activation token expired. A new token has been sent to your login");
        }
        var user = userRepository.findById(savedToken.getUser().getId()).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        user.setEnabled(true);
        userRepository.save(user);
        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
        senderService.sendCredentials(savedToken.getUser(), password);
    }



    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var claims = new HashMap<String, Object>();
        var user = ((User) auth.getPrincipal());
        claims.put("fullName", user.getFullName());
        var jwtToken = jwtService.generateToken(claims, (User) auth.getPrincipal());

        Employe employe = employeRepository.findByEmail(user.getUsername());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .employe(employe) // Ajoutez l'employé à la réponse
                .build();
    }


    public ResponseEntity resetPassword(ResetPasswordRequest request) {
        // Vérification que les deux nouveaux mots de passe sont identiques
        if (!request.getNewPassword().equals(request.getConfirmNewPassword())) {
            throw new IllegalStateException("New passwords do not match");
        }

        // Authentification de l'utilisateur avec son login et mot de passe actuel
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getCurrentPassword());
        try {
            authenticationManager.authenticate(authToken);
        } catch (AuthenticationException e) {
            throw new IllegalStateException("Current password is incorrect");
        }

        // Mise à jour du mot de passe dans la base de données
        User user = userRepository.findByLogin(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + request.getEmail()));
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("Password updated successfully");
    }

}
