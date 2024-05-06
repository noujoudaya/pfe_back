package sir.zproject.pfe_back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import sir.zproject.pfe_back.security.role.Role;
import sir.zproject.pfe_back.security.role.RoleRepository;
import sir.zproject.pfe_back.security.security.AuthoritiesConstants;
import sir.zproject.pfe_back.security.user.User;
import sir.zproject.pfe_back.security.user.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class PfeBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PfeBackApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            if (roleRepository.findByName("USER")==null) {
                roleRepository.save(Role.builder().name("USER").createdDate(LocalDateTime.now()).build());
            }
            if (roleRepository.findByName("ADMIN")==null && roleRepository.findByName("EMPLOYE")==null && roleRepository.findByName("SECRETAIRE")==null) {
                roleRepository.save(Role.builder().name(AuthoritiesConstants.ADMIN).createdDate(LocalDateTime.now()).build());
                roleRepository.save(Role.builder().name(AuthoritiesConstants.EMPLOYE).createdDate(LocalDateTime.now()).build());
                roleRepository.save(Role.builder().name(AuthoritiesConstants.SECRETAIRE).createdDate(LocalDateTime.now()).build());
            }

            //Create an admin account
            if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {
                List<Role> roles = new ArrayList<Role>();
                roles.add(roleRepository.findByName(AuthoritiesConstants.ADMIN));
                userRepository.save(User.builder()
                        .email("admin@gmail.com")
                        .password("1234")
                        .enabled(true)
                        .createdDate(LocalDateTime.now())
                        .accountLocked(false)
                        .roles(roles)
                        .build());
            }
            ;


        };
    }
}
