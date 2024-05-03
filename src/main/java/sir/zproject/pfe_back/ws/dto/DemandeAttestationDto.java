package sir.zproject.pfe_back.ws.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.StatutAttestation;
import sir.zproject.pfe_back.bean.TypeAttestation;

import java.time.LocalDate;

@Getter
@Setter
public class DemandeAttestationDto {
    private Long id;
    private Employe employe;
    private LocalDate dateDemande;
    private TypeAttestation typeAttestation;
    private StatutAttestation statutAttestation;

}
