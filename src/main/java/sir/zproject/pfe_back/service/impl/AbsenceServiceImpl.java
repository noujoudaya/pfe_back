package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.StatutAbsence;
import sir.zproject.pfe_back.dao.AbsenceDao;
import sir.zproject.pfe_back.service.facade.AbsenceService;

import java.time.LocalDate;
import java.util.List;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceDao absenceDao;

    @Override
    public List<Absence> findByEmploye(Employe employe) {
        return absenceDao.findByEmploye(employe);
    }

    @Override
    public int deleteByEmploye(Employe employe) {
        return absenceDao.deleteByEmploye(employe);
    }

    @Override
    public int deleteByDateAbsenceAndEmploye(LocalDate dateAbsence, Employe employe) {
        return absenceDao.deleteByDateAbsenceAndEmploye(dateAbsence,employe);
    }

    @Override
    public List<Absence> findByDateAbsence(LocalDate dateAbsence) {
        return absenceDao.findByDateAbsence(dateAbsence);
    }

    @Override
    public List<Absence> findByStatutAbsence(StatutAbsence statutAbsence) {
        return absenceDao.findByStatutAbsence(statutAbsence);
    }

    @Override
    public List<Absence> findAll() {
        return absenceDao.findAll();
    }

    @Override
    public int save(Absence absence) {
        return 0;
    }
}
