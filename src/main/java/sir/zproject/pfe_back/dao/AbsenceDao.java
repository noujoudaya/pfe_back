package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.StatutAbsence;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AbsenceDao extends JpaRepository<Absence,Long> {

    List<Absence> findByEmploye(Employe employe);

    int deleteByEmploye(Employe employe);

    int deleteByDateAbsenceAndEmploye(LocalDate dateAbsence, Employe employe);

    List<Absence> findByDateAbsence(LocalDate dateAbsence);

    List<Absence> findByStatutAbsence(StatutAbsence statutAbsence);




}
