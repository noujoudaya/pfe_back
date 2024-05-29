package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.BulletinPaie;
import sir.zproject.pfe_back.bean.Entreprise;
import sir.zproject.pfe_back.dao.EntrepriseDao;
import sir.zproject.pfe_back.service.facade.BulletinPaieService;
import sir.zproject.pfe_back.service.facade.EntrepriseService;

import java.util.List;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
    @Autowired
    private EntrepriseDao entrepriseDao;
    @Autowired
    private BulletinPaieService bulletinPaieService;

    @Override
    public Entreprise findByRaisonSociale(String rS) {
        return entrepriseDao.findByRaisonSociale(rS);
    }

    @Override
    public Entreprise findByIdentifiantFiscale(String idtFsc) {
        return entrepriseDao.findByIdentifiantFiscale(idtFsc);
    }

    @Override
    public Entreprise findByNumeroCNSS(Long cnss) {
        return entrepriseDao.findByNumeroCNSS(cnss);
    }

    @Override
    public Entreprise findByNumeromutuelle(Long mut) {
        return entrepriseDao.findByNumeromutuelle(mut);
    }

    @Override
    public Entreprise findByIce(String ice) {
        return entrepriseDao.findByIce(ice);
    }

    @Override
    public List<Entreprise> findAll() {
        return entrepriseDao.findAll();
    }

    @Override
    public int deleteByIce(String ice) {
        List<BulletinPaie> bulletinPaies = bulletinPaieService.findByEntrepriseIce(ice);
        if (bulletinPaies == null) {
            return entrepriseDao.deleteByIce(ice);
        } else {
            try {

                for (BulletinPaie bulletinPaie : bulletinPaies) {
                    bulletinPaieService.deleteByEntrepriseIce(bulletinPaie.getEntreprise().getIce());
                }


                return entrepriseDao.deleteByIce(ice) + 1;
            } catch (Exception e) {
                throw new RuntimeException("Failed to delete Entreprise", e);
            }

        }
    }

    @Override
    public int save(Entreprise entreprise) {
        if (entrepriseDao.findByIce(entreprise.getIce()) != null) {
            return -1;
        } else {
            entrepriseDao.save(entreprise);
            return 1;
        }
    }

    @Override
    public int update(Entreprise entreprise) {
        Entreprise existingEntreprise = entrepriseDao.findByIce(entreprise.getIce());
        if (existingEntreprise == null) {
            return -1;
        } else {
            existingEntreprise.setAdresse(entreprise.getAdresse());
            existingEntreprise.setNumeroCNSS(entreprise.getNumeroCNSS());
            existingEntreprise.setNumeromutuelle(entreprise.getNumeromutuelle());
            existingEntreprise.setIce(entreprise.getIce());
            existingEntreprise.setIdentifiantFiscale(entreprise.getIdentifiantFiscale());
            existingEntreprise.setRaisonSociale(entreprise.getRaisonSociale());
            entrepriseDao.save(existingEntreprise);
            return 1;

        }
    }
}
