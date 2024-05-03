package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.StatutEmploye;
@Repository
public interface StatutEmployeDao extends JpaRepository<StatutEmploye, Long> {
}
