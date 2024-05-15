package sir.zproject.pfe_back.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.dao.EmployeDao;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private EmployeDao employeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employe employe = employeRepository.findByEmail(username);
        if (employe == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec l'adresse e-mail: " + username);
        }
        return new User(employe.getEmail(), employe.getPassword(), getAuthorities(employe));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Employe employe) {
        return employe.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
