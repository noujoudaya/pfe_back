package sir.zproject.pfe_back.service.facade;

import sir.zproject.pfe_back.bean.Entreprise;

import java.util.List;

public interface EntrepriseService {

    Entreprise findByRaisonSociale(String rS);

    Entreprise findByIdentifiantFiscale(String idtFsc);

    Entreprise findByNumeroCNSS(Long cnss);

    Entreprise findByNumeromutuelle(Long mut);

    Entreprise findByIce(String ice);

    List<Entreprise> findAll();

    int deleteByIce(String ice);

    int save(Entreprise entreprise);

    int update(Entreprise entreprise);
}
