package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAbsence;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AbsenceService {

    List<Absence> findByEmploye(Employe employe);
    @Transactional
    int deleteByEmploye(Employe employe);
    @Transactional
    int deleteByDateAbsenceAndEmploye(LocalDate dateAbsence, Employe employe);

    List<Absence> findByDateAbsence(LocalDate dateAbsence);

    List<Absence> findByStatutAbsence(StatutAbsence statutAbsence);

    List<Absence> findAll();

    int save(Absence absence);
    int update(Absence absence);
    String justifier(Absence absence);
}
