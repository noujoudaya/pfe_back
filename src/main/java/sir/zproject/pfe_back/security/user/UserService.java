package sir.zproject.pfe_back.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    long count() {
        return userRepository.count();
    }

    public void changePassword(ChangePasswordRequest request, Principal principal) {

        // Extraire l'email de l'utilisateur à partir du token
        String email = getEmailFromToken(principal);

        // Rechercher l'utilisateur dans la base de données en utilisant l'email
        User user = userRepository.findByLogin(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));

        // Vérifier si le mot de passe actuel correspond
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Mot de passe actuel incorrect");
        }

        // Vérifier si les nouveaux mots de passe correspondent
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Le nouveau mot de passe et le mot de passe de confirmation ne sont pas identiques");
        }

        // Mettre à jour le mot de passe de l'utilisateur
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // Enregistrer les modifications dans la base de données
        userRepository.save(user);
    }


    // Méthode pour extraire l'email de l'utilisateur à partir du token
    private String getEmailFromToken(Principal principal) {
        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) principal;
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername(); // C'est généralement l'email dans la plupart des cas
        } else {
            throw new IllegalArgumentException("Principal is not an instance of UsernamePasswordAuthenticationToken.");
        }
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    List<User> findPureUsers() {
        return userRepository.findPureUsers();
    }

    long countPureUsers() {
        return userRepository.countPureUsers();
    }

    @Transactional
    int deleteByLogin(String login) {
        return this.userRepository.deleteByLogin(login);
    }

    public Page<User> getPureUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findPureUsers(pageable);
    }

}
