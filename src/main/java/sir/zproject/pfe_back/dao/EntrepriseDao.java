package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Entreprise;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Long> {
    Entreprise findByIce(String ice);
    Entreprise findByRaisonSociale(String rS);
    Entreprise findByIdentifiantFiscale(String idtFsc);
    Entreprise findByNumeroCNSS(Long cnss);
    Entreprise findByNumeromutuelle(Long mut);

    int deleteByIce(String ice);

}
