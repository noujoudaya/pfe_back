package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.BulletinPaie;

import java.util.List;
import java.util.Optional;

@Repository
public interface BulletinPaieDao extends JpaRepository<BulletinPaie,Long> {
    List<BulletinPaie> findByEmployeMatricule (Long matricule);
    List<BulletinPaie> findByEmployeNom (String nom);
    List<BulletinPaie> findByEmployePrenom (String prenom);
    List<BulletinPaie> findByEntrepriseIce (String ice);
    BulletinPaie findByMonth (String month);
    List<BulletinPaie> findByYear (int year);
    BulletinPaie findByCode (Long code);
    int deleteByEmployeMatricule (Long matricule);
    int deleteByEntrepriseIce (String ice);

    @Query("SELECT b FROM BulletinPaie b LEFT JOIN FETCH b.bulletinPaieRubriques")
    List<BulletinPaie> findAllWithRubriques();


}
