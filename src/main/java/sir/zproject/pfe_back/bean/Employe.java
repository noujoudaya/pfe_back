package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.EnableAsync;

@Entity
@Getter
@Setter
public class Employe {
    @Id
    private Long id;


}
