package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAbsence;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbsenceDao extends JpaRepository<Absence, Long> {

    List<Absence> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByDateAbsenceAndEmploye(LocalDate dateAbsence, Employe employe);

    List<Absence> findByDateAbsence(LocalDate dateAbsence);

    List<Absence> findByStatutAbsence(StatutAbsence statutAbsence);

    @Query("SELECT a FROM Absence a WHERE " +
            "LOWER(a.employe.nom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.employe.prenom) LIKE LOWER(CONCAT('%', :search, '%')) ")
    List<Absence> searchByAllAttributs(@Param("search") String search);

    List<Absence> findByEmployeDepartement(Departement departement);

    Page<Absence> findByEmployeDepartement(Departement departement, Pageable pageable);


}
