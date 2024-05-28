package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;

@Repository
public interface FonctionDao extends JpaRepository<Fonction ,Long> {
    List<Fonction> findByServiceCode(String code);

    int deleteByServiceCode(String code);
    Fonction findByCode(String code);

    Fonction findByLibelle(String libelle);

    int deleteByCode(String code);

    List<Fonction> findAll();

    @Override
    Page<Fonction> findAll(Pageable pageable);

}
