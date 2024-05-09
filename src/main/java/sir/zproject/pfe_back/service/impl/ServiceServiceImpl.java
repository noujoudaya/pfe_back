package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.dao.ServiceDao;
import sir.zproject.pfe_back.service.facade.ServiceService;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceDao serviceDao;
    @Override
    public sir.zproject.pfe_back.bean.Service findByCode(String code) {
        return serviceDao.findByCode(code);
    }

    @Override
    public sir.zproject.pfe_back.bean.Service findByLibelle(String libelle) {
        return serviceDao.findByLibelle(libelle);
    }

    @Override
    public List<sir.zproject.pfe_back.bean.Service> findByDepartement(Departement departement) {
        return serviceDao.findByDepartement(departement);
    }

    @Override
    @Transactional
    public int deleteByDepartement(Departement departement) {
        return serviceDao.deleteByDepartement(departement);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return serviceDao.deleteByCode(code);
    }

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {
        return serviceDao.deleteByLibelle(libelle);
    }

    @Override
    public List<sir.zproject.pfe_back.bean.Service> findAll() {
        return serviceDao.findAll();
    }

    @Override
    public int save(sir.zproject.pfe_back.bean.Service service) {
        if (service == null) {
            return 0;
        }
        if (service.getId() != null && serviceDao.findById(service.getId()).isPresent()) {
            return -1;
        }
        serviceDao.save(service);
        return 1;
    }
}
