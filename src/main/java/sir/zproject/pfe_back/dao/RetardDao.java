package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.enumeration.StatutAbsence;
import sir.zproject.pfe_back.enumeration.StatutConge;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface RetardDao extends JpaRepository<Retard,Long> {

    List<Retard> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByDateRetardAndEmploye(LocalDate dateRetard, Employe employe);

    int deleteByDateRetard(LocalDate dateRetard);
    List<Retard> findByDateRetard(LocalDate dateRetard);

    List<Retard> findByHeureDebutTravail(LocalTime heureDebutTravail);
    List<Retard> findByStatutRetard(StatutAbsence statutRetard);

    @Query("SELECT r FROM Retard r WHERE " +
            "LOWER(r.employe.nom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(r.employe.prenom) LIKE LOWER(CONCAT('%', :search, '%')) ")
    List<Retard> searchByAllAttributs(@Param("search") String search);

}
