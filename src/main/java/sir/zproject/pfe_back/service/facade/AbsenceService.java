package sir.zproject.pfe_back.service.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.*;
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
    List<Absence> searchByAllAttributs(@Param("search") String search);

    List<Absence> findByEmployeDepartement(Departement departement);

    Page<Absence> getAbsences(Departement departement,int page, int size);
}
