package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.TypeConge;
import sir.zproject.pfe_back.dao.TypeCongeDao;
import sir.zproject.pfe_back.service.facade.TypeCongeService;

import java.util.List;

@Service
public class TypeCongeServiceImpl implements TypeCongeService {

    @Autowired
    private TypeCongeDao typeCongeDao;
    @Override
    public TypeConge findByCode(String code) {
        return typeCongeDao.findByCode(code);
    }

    @Override
    public TypeConge findByLibelle(String libelle) {
        return typeCongeDao.findByLibelle(libelle);
    }

    @Override
    public int deleteByCode(String code) {
        return typeCongeDao.deleteByCode(code);
    }

    @Override
    public int deleteByLibelle(String libelle) {
        return typeCongeDao.deleteByLibelle(libelle);
    }

    @Override
    public List<TypeConge> findAll() {
        return typeCongeDao.findAll();
    }

    @Override
    public int save(TypeConge typeConge) {
        return 0;
    }
}