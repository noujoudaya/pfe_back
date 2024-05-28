package sir.zproject.pfe_back.service.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DemandeAttestationService {

    List<DemandeAttestation> findByEmploye(Employe employe);
    @Transactional
    int deleteByEmploye(Employe employe);

    @Transactional
    int deleteByEmployeIdAndDateDemande(long employeId, LocalDate dateDemande);

    List<DemandeAttestation> findByDateDemande(LocalDate dateDemande);
    List<DemandeAttestation> findByTypeAttestation(TypeAttestation typeAttestation);

    List<DemandeAttestation> findByStatutAttestation(StatutAttestation statutAttestation);

    List<DemandeAttestation> findAll();

    int save(DemandeAttestation demandeAttestation);

    public String preparerDemande(DemandeAttestation demande);
    public String validerDemande(DemandeAttestation demande);
    int update(DemandeAttestation demandeAttestation);

    long countByStatutDemande();
    List<DemandeAttestation> searchByAllAttributs(@Param("search") String search);

    Page<DemandeAttestation> getDemandesAttest(int page, int size);
}
