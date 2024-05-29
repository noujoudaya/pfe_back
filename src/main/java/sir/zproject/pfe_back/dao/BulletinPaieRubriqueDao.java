package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.BulletinPaieRubrique;

import java.util.List;

@Repository
public interface BulletinPaieRubriqueDao extends JpaRepository<BulletinPaieRubrique,Long> {

    List<BulletinPaieRubrique> findByBulletinPaieId(Long id);
}
