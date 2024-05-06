package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.service.facade.EmployeService;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeDao employeDao;
    @Override
    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    @Override
    public Employe findByEmail(String email) {
        return employeDao.findByEmail(email);
    }

    @Override
    public Employe findByTelephone(String telephone) {
        return employeDao.findByTelephone(telephone);
    }

    @Override
    public List<Employe> findByNomAndPrenom(String nom, String prenom) {
        return employeDao.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public List<Employe> findByDepartement(Departement departement) {
        return employeDao.findByDepartement(departement);
    }

    @Override
    public List<Employe> findByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.findByService(service);
    }

    @Override
    public List<Employe> findByFonction(Fonction fonction) {
        return employeDao.findByFonction(fonction);
    }

    @Override
    public List<Employe> findByVille(String ville) {
        return employeDao.findByVille(ville);
    }

    @Override
    @Transactional
    public int deleteByNomAndPrenom(String nom, String prenom) {
        return employeDao.deleteByNomAndPrenom(nom, prenom);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByEmail(String email) {
        return employeDao.deleteByEmail(email);
    }

    @Override
    public int deleteByDepartement(Departement departement) {
        return employeDao.deleteByDepartement(departement);
    }

    @Override
    @Transactional
    public int deleteByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.deleteByService(service);
    }

    @Override
    @Transactional
    public int deleteByFonction(Fonction fonction) {
        return employeDao.deleteByFonction(fonction);
    }

    @Override
    public int countEmployeByDepartement(Departement departement) {
        return employeDao.countEmployeByDepartement(departement);
    }

    @Override
    public int countEmployeByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.countEmployeByService(service);
    }

    @Override
    public int countEmployeByFonction(Fonction fonction) {
        return employeDao.countEmployeByFonction(fonction);
    }

    @Override
    public int countEmployeByVille(String ville) {
        return employeDao.countEmployeByVille(ville);
    }

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override
    public int save(Employe employe) {
        if (employe == null) {
            return 0;
        }
        if (employe.getId() != null && employeDao.findById(employe.getId()).isPresent()) {
            return -1;
        }
        employeDao.save(employe);
        return 1;
    }
}