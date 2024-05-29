package sir.zproject.pfe_back.service.facade;


import org.springframework.data.domain.Page;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Fonction;

import java.util.List;

public interface FonctionService {


    List<Fonction> findByServiceCode(String code);
    int deleteByServiceCode(String code);
    Fonction findByCode(String code);

    Fonction findByLibelle(String libelle);

    int deleteByCode(String code);

    List<Fonction> findAll();


    int save(Fonction fonction);


    int update(Fonction newFonction);

    Page<Fonction> getFonctions(int page, int size);
}
