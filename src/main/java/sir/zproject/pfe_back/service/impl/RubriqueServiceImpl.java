package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.*;
import sir.zproject.pfe_back.dao.RubriqueDao;
import sir.zproject.pfe_back.service.facade.RubriqueService;

import java.util.List;

@Service
public class RubriqueServiceImpl implements RubriqueService {
    @Autowired
    private RubriqueDao rubriqueDao;
    @Autowired
    private RubriqueService rubriqueService;



    @Override
    public Rubrique findByCode(Long code) {
        return rubriqueDao.findByCode(code);
    }
}
