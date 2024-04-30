package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Retard;

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

}
