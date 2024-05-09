package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.StatutAbsence;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Absence {
    @Id
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateAbsence;
    private StatutAbsence statutAbsence;


}
