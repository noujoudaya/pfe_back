package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Secretaire;

@Repository
public interface SecretaireDao extends JpaRepository<Secretaire,Long> {
}
