package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.StatutAbsence;
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
    public int deleteByEmploye(Employe employe) {
        return absenceDao.deleteByEmploye(employe);
    }

    @Override
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
    public String save(Absence absence) {
        if (absence == null) {
            return "L'objet absence ne doit pas être null";
        }
        if (absence.getId() != null && absenceDao.findById(absence.getId()).isPresent()) {
            return "Cette absence existe déjà";
        }
        if (absence.getEmploye() == null) {
            return "L'employé est obligatoire";
        }
        Optional<Employe> employeOptional = employeDao.findById(absence.getEmploye().getId());
        if (employeOptional.isEmpty()) {
            return "Aucun employé trouvé avec cet ID";
        }

        absence.setEmploye(employeOptional.get());
        absence.setStatutAbsence(StatutAbsence.NonJustifie);
        absenceDao.save(absence);
        return "Absence ajoutée avec succès";
    }

    @Override
    public String justifier(Absence absence) {
        absence.setStatutAbsence(StatutAbsence.Justifie);
        absenceDao.save(absence);
        return "Absence justifier avec succès";
    }

}
