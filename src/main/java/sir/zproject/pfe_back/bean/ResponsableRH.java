package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResponsableRH extends Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
