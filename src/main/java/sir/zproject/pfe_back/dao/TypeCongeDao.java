package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.TypeConge;

@Repository
public interface TypeCongeDao extends JpaRepository<TypeConge,Long> {

    TypeConge findByCode(String code);

    TypeConge findByLibelle(String libelle);

    int deleteByCode(String code);

    int deleteByLibelle(String libelle);
}
