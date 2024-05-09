package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.dao.RetardDao;
import sir.zproject.pfe_back.service.facade.RetardService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class RetardServiceImpl implements RetardService {

    @Autowired
    private RetardDao retardDao;
    @Autowired
    private EmployeDao employeDao;
    @Override
    public List<Retard> findByEmploye(Employe employe) {
        return retardDao.findByEmploye(employe);
    }

    @Override
    public int deleteByEmploye(Employe employe) {
        return retardDao.deleteByEmploye(employe);
    }

    @Override
    public int deleteByDateRetardAndEmploye(LocalDate dateRetard, Employe employe) {
        return retardDao.deleteByDateRetardAndEmploye(dateRetard,employe);
    }

    @Override
    public int deleteByDateRetard(LocalDate dateRetard) {
        return retardDao.deleteByDateRetard(dateRetard);
    }

    @Override
    public List<Retard> findByDateRetard(LocalDate dateRetard) {
        return retardDao.findByDateRetard(dateRetard);
    }

    @Override
    public List<Retard> findByHeureDebutTravail(LocalTime heureDebutTravail) {
        return retardDao.findByHeureDebutTravail(heureDebutTravail);
    }

    @Override
    public List<Retard> findAll() {
        return retardDao.findAll();
    }

    @Override
    public int save(Retard retard) {
        if (retard== null) {
            return 0;
        }
        if (retard.getId() != null && retardDao.findById(retard.getId()).isPresent()) {
            return -1;
        }
        if (retard.getEmploye() == null) {
            return -2;
        }
        Optional<Employe> employeOptional = employeDao.findById(retard.getEmploye().getId());
        if (employeOptional.isEmpty()) {
            return -3;
        }

        retard.setEmploye(employeOptional.get());
        retardDao.save(retard);
        return 1;
    }

    @Override
    public int update(Retard retard) {
        Retard existingRetard = retardDao.findById(retard.getId()).orElse(null);
        if (existingRetard == null) {
            return -1;
        }
        existingRetard.setEmploye(retard.getEmploye());
        existingRetard.setDateRetard(retard.getDateRetard());
        existingRetard.setHeureArrivee(retard.getHeureArrivee());
        existingRetard.setHeureDebutTravail(retard.getHeureDebutTravail());
        retardDao.save(existingRetard);
        return 1;
    }
}
