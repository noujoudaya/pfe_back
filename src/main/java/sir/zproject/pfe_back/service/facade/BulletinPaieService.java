package sir.zproject.pfe_back.service.facade;

import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.BulletinPaie;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface BulletinPaieService {
    List<BulletinPaie> findByEmployeMatricule(Long matricule);

    List<BulletinPaie> findByEmployeNom(String nom);

    List<BulletinPaie> findByEmployePrenom(String prenom);

    BulletinPaie findByMonth(String month);

    List<BulletinPaie> findByYear(int year);

    BulletinPaie findByCode (Long code);

    List<BulletinPaie> findByEntrepriseIce(String ice);


    @Transactional
    int deleteByEntrepriseIce(String ice);

    List<BulletinPaie> findAll();

    int deleteByEmployeMatricule(Long matricule);

    int save(BulletinPaie bulletinPaie);

    Resource toPdf(BulletinPaie bulletinPaiee) throws IOException;

    Resource getPdfByCode(String code) throws IOException;
}
