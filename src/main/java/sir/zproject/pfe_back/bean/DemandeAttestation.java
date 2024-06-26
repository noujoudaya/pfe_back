package sir.zproject.pfe_back.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DemandeAttestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateDemande;
    private TypeAttestation typeAttestation;
    private StatutAttestation statutAttestation;

}
