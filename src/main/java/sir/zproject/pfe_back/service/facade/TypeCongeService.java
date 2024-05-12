package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.TypeConge;

import java.util.List;

@Service
public interface TypeCongeService {

    TypeConge findByCode(String code);

    TypeConge findByLibelle(String libelle);

    @Transactional
    int deleteByCode(String code);

    @Transactional
    int deleteByLibelle(String libelle);

    List<TypeConge> findAll();

    int save(TypeConge typeConge);
}
