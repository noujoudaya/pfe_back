package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.dao.RetardDao;
import sir.zproject.pfe_back.service.facade.RetardService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class RetardServiceImpl implements RetardService {

    @Autowired
    private RetardDao retardDao;
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
        return 0;
    }
}