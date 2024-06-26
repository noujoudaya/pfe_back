package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Rubrique;

@Repository
public interface RubriqueDao extends JpaRepository<Rubrique,Long > {
  Rubrique findByCode (Long code);

}
