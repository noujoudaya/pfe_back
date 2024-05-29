package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DemandeAttestationDao extends JpaRepository<DemandeAttestation,Long> {

    List<DemandeAttestation> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByEmployeIdAndDateDemande(long employeId,LocalDate dateDemande);
    List<DemandeAttestation> findByDateDemande(LocalDate dateDemande);
    List<DemandeAttestation> findByTypeAttestation(TypeAttestation typeAttestation);

    List<DemandeAttestation> findByStatutAttestation(StatutAttestation statutAttestation);

    long countByStatutAttestation(StatutAttestation statutAttestation);

    @Query("SELECT d FROM DemandeAttestation d WHERE " +
            "LOWER(d.employe.nom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.employe.prenom) LIKE LOWER(CONCAT('%', :search, '%')) ")
    List<DemandeAttestation> searchByAllAttributs(@Param("search") String search);

    @Override
    Page<DemandeAttestation> findAll(Pageable pageable);

    Page<DemandeAttestation> findByEmploye(Employe employe,Pageable pageable);
}
