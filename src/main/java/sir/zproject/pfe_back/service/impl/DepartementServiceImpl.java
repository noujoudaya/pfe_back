package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.dao.DepartementDao;
import sir.zproject.pfe_back.service.facade.DepartementService;
import sir.zproject.pfe_back.service.facade.FonctionService;
import sir.zproject.pfe_back.service.facade.ServiceService;

import java.util.List;


@Service

public class DepartementServiceImpl implements DepartementService {
    @Autowired
    private  DepartementDao departementDao;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private FonctionService fonctionService;


    @Override
    public Departement findByCode(String code) {
        return departementDao.findByCode(code);
    }
    @Override
    public Departement findByLibelle(String libelle) {return departementDao.findByLibelle(libelle);}

    @Transactional
    @Override
    public int deleteByCode(String code) {
        List<sir.zproject.pfe_back.bean.Service> services = serviceService.findByDepartementCode(code);

        if (services == null) {
            return departementDao.deleteByCode(code);
        } else {
            try {
                for (sir.zproject.pfe_back.bean.Service service : services) {
                    List<Fonction> fonctions = fonctionService.findByServiceCode(service.getCode());
                    if (fonctions != null) {
                        for (Fonction fonction : fonctions) {
                            fonctionService.deleteByCode(fonction.getCode());
                        }
                    }
                    serviceService.deleteByCode(service.getCode());
                }
                return departementDao.deleteByCode(code) + 1;
            } catch (Exception e) {
                throw new RuntimeException("Failed to delete department and related services", e);
            }
        }
    }

    @Override
    public List<Departement> findAll() {
        return departementDao.findAll();
    }

    @Override
    public int save(Departement departement) {
        Departement existingdepartement = findByLibelle(departement.getLibelle());
        if (existingdepartement == null) {
            departementDao.save(departement);
            return 1;
        } else {
            return -1;
        }
    }


    @Override
    public int update(Departement newDepartement) {
        Departement departement = findByCode(newDepartement.getCode());
        if (departement == null) {
            return -1;
        } else {
            departement.setCode(newDepartement.getLibelle());
            departement.setLibelle(newDepartement.getLibelle());
            departementDao.save(departement);
            return 1;
        }
    }
}
