package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.dao.FonctionDao;

import sir.zproject.pfe_back.service.facade.FonctionService;
import sir.zproject.pfe_back.service.facade.ServiceService;

import java.util.List;

@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private FonctionDao fonctionDao;


    @Override
    public List<Fonction> findByServiceCode(String code) {
        return fonctionDao.findByServiceCode(code);
    }

    @Transactional
    @Override
    public int deleteByServiceCode(String code) {
        return fonctionDao.deleteByServiceCode(code);
    }

    @Override
    public Fonction findByCode(String code) {
        return fonctionDao.findByCode(code);
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        return fonctionDao.findByLibelle(libelle);
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
        return fonctionDao.deleteByCode(code);
    }

    @Override
    public List<Fonction> findAll() {
        return fonctionDao.findAll();
    }

    public int save(Fonction fonction) {


        sir.zproject.pfe_back.bean.Service service = serviceService.findByLibelle(fonction.getService().getLibelle());
        fonction.setService(service);
        Fonction existingFonction = findByLibelle(fonction.getLibelle());

        if (service == null) {
            return -1;
        } else if  (existingFonction != null) {
            return 0;
        }

        else {
            fonctionDao.save(fonction);
            return 1;
        }

    }


    @Override
    public int update(Fonction newFonction) {
        Fonction fonction = findByCode(newFonction.getCode());
        if (fonction == null) {
            return -1;
        } else {
            fonction.setCode(newFonction.getLibelle());
            fonction.setLibelle(newFonction.getLibelle());
            fonctionDao.save(fonction );
            return 1;
        }
    }

    @Override
    public Page<Fonction> getFonctions(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return fonctionDao.findAll(pageable);
    }

}
