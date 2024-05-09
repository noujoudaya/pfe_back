package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.dao.FonctionDao;
import sir.zproject.pfe_back.service.facade.FonctionService;

import java.util.List;

@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    private FonctionDao fonctionDao;
    @Override
    public Fonction findByCode(String code) {
        return fonctionDao.findByCode(code);
    }

    @Override
    public Fonction findByLibelle(String libelle) {
        return fonctionDao.findByLibelle(libelle);
    }

    @Override
    public List<Fonction> findByService(sir.zproject.pfe_back.bean.Service service) {
        return fonctionDao.findByService(service);
    }

    @Override
    @Transactional
    public int deleteByService(sir.zproject.pfe_back.bean.Service service) {
        return fonctionDao.deleteByService(service);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return fonctionDao.deleteByCode(code);
    }

    @Override
    @Transactional
    public int deleteByLibelle(String libelle) {
        return fonctionDao.deleteByLibelle(libelle);
    }

    @Override
    public List<Fonction> findAll() {
        return fonctionDao.findAll();
    }

    @Override
    public int save(Fonction fonction) {
        if (fonction== null) {
            return 0;
        }
        if (fonction.getId() != null && fonctionDao.findById(fonction.getId()).isPresent()) {
            return -1;
        }
        fonctionDao.save(fonction);
        return 1;
    }
}
