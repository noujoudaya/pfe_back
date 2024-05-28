package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutConge;
import sir.zproject.pfe_back.bean.TypeConge;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DemandeCongeDao extends JpaRepository<DemandeConge, Long> {
    List<DemandeConge> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(LocalDate dateDemande, long employeId, String typeCongeLibelle);

    int deleteByStatutConge(StatutConge statutConge);

    int deleteByTypeConge(TypeConge typeConge);

    int deleteByDateDebut(LocalDate dateDebut);

    int deleteByDateFin(LocalDate dateFin);

    List<DemandeConge> findByDateDemande(LocalDate dateDemande);

    List<DemandeConge> findByDateDebut(LocalDate dateDebut);

    List<DemandeConge> findByDateFin(LocalDate dateFin);

    List<DemandeConge> findByTypeConge(TypeConge typeConge);

    List<DemandeConge> findByStatutConge(StatutConge statutConge);

    long countByStatutConge(StatutConge statutConge);

    @Query("SELECT d FROM DemandeConge d WHERE " +
            "LOWER(d.employe.nom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.employe.prenom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(d.typeConge.libelle) LIKE LOWER(CONCAT('%', :search, '%')) ")
    List<DemandeConge> searchByAllAttributs(@Param("search") String search);

    @Override
    Page<DemandeConge> findAll(Pageable pageable);

}
