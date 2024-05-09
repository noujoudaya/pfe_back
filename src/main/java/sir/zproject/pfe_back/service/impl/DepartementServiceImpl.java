package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.dao.DepartementDao;
import sir.zproject.pfe_back.service.facade.DepartementService;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementDao departementDao;
    @Override
    public Departement findByCode(String code) {
        return departementDao.findByCode(code);
    }

    @Override
    public Departement findByLibelle(String libelle) {
        return departementDao.findByLibelle(libelle);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return departementDao.deleteByCode(code);
    }

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {
        return departementDao.deleteByLibelle(libelle);
    }

    @Override
    public List<Departement> findAll() {
        return departementDao.findAll();
    }

    @Override
    public int save(Departement departement) {
        if (departement == null) {
            return 0;
        }
        if (departement.getId() != null && departementDao.findById(departement.getId()).isPresent()) {
            return -1;
        }
        departementDao.save(departement);
        return 1;
    }
    }

