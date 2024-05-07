package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Fonction;

import java.util.List;

@Service
public interface FonctionService {

    Fonction findByCode(String code);
    Fonction findByLibelle(String libelle);
    List<Fonction> findByService(sir.zproject.pfe_back.bean.Service service);
    int deleteByService(sir.zproject.pfe_back.bean.Service service);
    int deleteByCode(String code);
    int deleteByLibelle(String libelle);
    List<Fonction> findAll();
    int save(Fonction fonction);
}
