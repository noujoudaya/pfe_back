package sir.zproject.pfe_back.service.facade;

import sir.zproject.pfe_back.bean.Rubrique;

import java.util.List;

public interface RubriqueService {


    Rubrique findByCode(Long code);
}
