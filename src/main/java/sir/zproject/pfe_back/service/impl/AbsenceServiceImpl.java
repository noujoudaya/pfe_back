package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAbsence;
import sir.zproject.pfe_back.dao.AbsenceDao;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.service.facade.AbsenceService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    @Autowired
    private AbsenceDao absenceDao;
    @Autowired
    private EmployeDao employeDao;

    @Override
    public List<Absence> findByEmploye(Employe employe) {
        return absenceDao.findByEmploye(employe);
    }

    @Override
    @Transactional
    public int deleteByEmploye(Employe employe) {
        return absenceDao.deleteByEmploye(employe);
    }

    @Override
    @Transactional
    public int deleteByDateAbsenceAndEmploye(LocalDate dateAbsence, Employe employe) {
        return absenceDao.deleteByDateAbsenceAndEmploye(dateAbsence, employe);
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
        if (absence == null) {
            return 0;
        }
        if (absence.getId() != null && absenceDao.findById(absence.getId()).isPresent()) {
            return -1;
        }
        if (absence.getEmploye() == null) {
            System.out.println("Employe is null");
            return -2;
        }
        Optional<Employe> employeOptional = employeDao.findById(absence.getEmploye().getId());
        if (employeOptional.isEmpty()) {
            return -3;
        }

        absence.setEmploye(employeOptional.get());
        absence.setStatutAbsence(StatutAbsence.Non_Justifiée);
        absenceDao.save(absence);
        return 1;
    }

    @Override
    public int update(Absence absence) {
        Absence existingAbsence = absenceDao.findById(absence.getId()).orElse(null);
        if (existingAbsence == null) {
            return 0;
        }
        existingAbsence.setEmploye(absence.getEmploye());
        existingAbsence.setDateAbsence(absence.getDateAbsence());
        existingAbsence.setStatutAbsence(absence.getStatutAbsence());
        absenceDao.save(existingAbsence);
        return 1;
    }

    @Override
    public String justifier(Absence absence) {
        absence.setStatutAbsence(StatutAbsence.Justifiée);
        update(absence);
        return "Absence justifier avec succès";
    }

}
