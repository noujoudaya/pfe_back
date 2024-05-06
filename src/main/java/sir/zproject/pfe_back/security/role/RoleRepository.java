package sir.zproject.pfe_back.security.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findByName(String name);
}
