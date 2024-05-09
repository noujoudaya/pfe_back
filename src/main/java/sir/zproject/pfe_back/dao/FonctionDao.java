package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;

@Repository
public interface FonctionDao extends JpaRepository<Fonction ,Long> {

    Fonction findByCode(String code);
    Fonction findByLibelle(String libelle);
    List<Fonction> findByService(Service service);
    int deleteByService(Service service);
    int deleteByCode(String code);
    int deleteByLibelle(String libelle);

}
