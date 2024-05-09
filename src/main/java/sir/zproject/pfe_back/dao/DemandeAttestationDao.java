package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DemandeAttestationDao extends JpaRepository<DemandeAttestation,Long> {

    List<DemandeAttestation> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByEmployeAndDateDemande(Employe employe,LocalDate dateDemande);
    List<DemandeAttestation> findByDateDemande(LocalDate dateDemande);
    List<DemandeAttestation> findByTypeAttestation(TypeAttestation typeAttestation);

    List<DemandeAttestation> findByStatutAttestation(StatutAttestation statutAttestation);

}
