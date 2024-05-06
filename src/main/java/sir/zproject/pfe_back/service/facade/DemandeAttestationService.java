package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.StatutAttestation;
import sir.zproject.pfe_back.bean.TypeAttestation;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DemandeAttestationService {

    List<DemandeAttestation> findByEmploye(Employe employe);
    @Transactional
    int deleteByEmploye(Employe employe);

    @Transactional
    int deleteByEmployeAndDateDemande(Employe employe, LocalDate dateDemande);

    List<DemandeAttestation> findByDateDemande(LocalDate dateDemande);
    List<DemandeAttestation> findByTypeAttestation(TypeAttestation typeAttestation);

    List<DemandeAttestation> findByStatutAttestation(StatutAttestation statutAttestation);

    List<DemandeAttestation> findAll();

    String save(DemandeAttestation demandeAttestation);

    public String preparerDemande(DemandeAttestation demande);
    public String validerDemande(DemandeAttestation demande);
}
