package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.EnableAsync;
import sir.zproject.pfe_back.security.role.Role;
import sir.zproject.pfe_back.security.security.AuthoritiesConstants;
import sir.zproject.pfe_back.security.user.User;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Employe extends User {

    @Id
    private Long id;

}
