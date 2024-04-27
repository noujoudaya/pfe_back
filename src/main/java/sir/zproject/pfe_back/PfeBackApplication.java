package sir.zproject.pfe_back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import sir.zproject.pfe_back.security.role.Role;
import sir.zproject.pfe_back.security.role.RoleRepository;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class PfeBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfeBackApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository){
		return args -> {
			if(roleRepository.findByName("USER").isEmpty()){
				roleRepository.save(Role.builder().name("USER").createdDate(LocalDateTime.now()).build());
			}
		};
	}
}
