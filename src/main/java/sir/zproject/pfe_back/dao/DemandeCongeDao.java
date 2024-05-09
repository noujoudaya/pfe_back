package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
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

    int deleteByStatutConge(StatutConge statutConge);

    int deleteByTypeConge(TypeConge typeConge);

    int deleteByDateDebut(LocalDate dateDebut);

    int deleteByDateFin(LocalDate dateFin);

    List<DemandeConge> findByDateDemande(LocalDate dateDemande);
    List<DemandeConge> findByDateDebut(LocalDate dateDebut);
    List<DemandeConge> findByDateFin(LocalDate dateFin);

    List<DemandeConge> findByTypeConge(TypeConge typeConge);
    List<DemandeConge> findByStatutConge(StatutConge statutConge);


}
