package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.dao.ServiceDao;
import sir.zproject.pfe_back.service.facade.DepartementService;
import sir.zproject.pfe_back.service.facade.ServiceService;

import java.util.List;


@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private DepartementService departementService;
    @Autowired
    private  ServiceDao serviceDao;


    @Override
    public List<sir.zproject.pfe_back.bean.Service> findByDepartementCode(String code) {
        return serviceDao.findByDepartementCode(code);
    }

    @Transactional
    @Override
    public int deleteByDepartementCode(String code) {
        return serviceDao.deleteByDepartementCode(code);
    }

    @Override
    public sir.zproject.pfe_back.bean.Service findByCode(String code) {
        return serviceDao.findByCode(code);
    }

    @Override
    public sir.zproject.pfe_back.bean.Service findByLibelle(String libelle) {
        return serviceDao.findByLibelle(libelle);
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
        return serviceDao.deleteByCode(code);
    }

    @Override
    public List<sir.zproject.pfe_back.bean.Service> findAll() {
        return serviceDao.findAll();
    }

    public int save(sir.zproject.pfe_back.bean.Service service) {


        Departement departement = departementService.findByLibelle(service.getDepartement().getLibelle());
        service.setDepartement(departement);
        sir.zproject.pfe_back.bean.Service existingService = findByLibelle(service.getLibelle());

        if (departement == null) {
            return -1;
        } else if  (existingService != null) {
            return 0;
        }

        else {
            serviceDao.save(service);
            return 1;
        }

    }


    @Override
    public int update(sir.zproject.pfe_back.bean.Service newService) {
        sir.zproject.pfe_back.bean.Service service = findByCode(newService.getCode());
        if (service == null) {
            return -1;
        } else {
            service.setCode(newService.getLibelle());
            service.setLibelle(newService.getLibelle());
            serviceDao.save(service);
            return 1;
        }
    }



}




