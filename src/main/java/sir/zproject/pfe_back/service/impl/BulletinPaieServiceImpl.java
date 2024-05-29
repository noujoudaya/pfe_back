package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.spring6.SpringTemplateEngine;
import sir.zproject.pfe_back.bean.*;
import sir.zproject.pfe_back.dao.BulletinPaieDao;
import sir.zproject.pfe_back.dao.BulletinPaieRubriqueDao;
import sir.zproject.pfe_back.service.facade.BulletinPaieService;
import sir.zproject.pfe_back.service.facade.EmployeService;
import sir.zproject.pfe_back.service.facade.EntrepriseService;
import sir.zproject.pfe_back.service.facade.RubriqueService;
import sir.zproject.pfe_back.service.util.PdfUtil;
import sir.zproject.pfe_back.ws.converter.BulletinCalculeConverter;
import sir.zproject.pfe_back.ws.dto.BulletinPaieDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class BulletinPaieServiceImpl implements BulletinPaieService {
    @Autowired
    private BulletinPaieDao bulletinPaieDao;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private EntrepriseService entrepriseService;
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private RubriqueService rubriqueService;
    @Autowired
    private BulletinPaieRubriqueDao bulletinPaieRubriqueDao;
    @Autowired
    private BulletinCalculeConverter bulletinCalculeConverter;


    @Override
    public List<BulletinPaie> findByEmployeMatricule(Long matricule) {
        return bulletinPaieDao.findByEmployeMatricule(matricule);
    }

    @Override
    public List<BulletinPaie> findByEmployeNom(String nom) {
        return bulletinPaieDao.findByEmployeNom(nom);
    }

    @Override
    public List<BulletinPaie> findByEmployePrenom(String prenom) {
        return bulletinPaieDao.findByEmployePrenom(prenom);
    }

    @Override
    public BulletinPaie findByMonth(String month) {
        return bulletinPaieDao.findByMonth(month);
    }

    @Override
    public List<BulletinPaie> findByYear(int year) {
        return bulletinPaieDao.findByYear(year);
    }

    @Override
    public BulletinPaie findByCode(Long code) {
        return bulletinPaieDao.findByCode(code);
    }

    @Override
    public List<BulletinPaie> findByEntrepriseIce(String ice) {
        return bulletinPaieDao.findByEntrepriseIce(ice);
    }

    @Override
    @Transactional
    public int deleteByEntrepriseIce(String ice) {
        return bulletinPaieDao.deleteByEntrepriseIce(ice);
    }

    @Override
    public List<BulletinPaie> findAll() {
        return bulletinPaieDao.findAll();
    }

   /* @Transactional
    public List<BulletinPaie> findAll() {
        List<BulletinPaie> allBps = bulletinPaieDao.findAll();

        for (BulletinPaie bulletinPaie : allBps) {
            // Fetch and set employe
            Employe employe = employeService.findByMatricule(bulletinPaie.getEmploye().getMatricule());
            bulletinPaie.setEmploye(employe);

            // Fetch and set entreprise
            Entreprise entreprise = entrepriseService.findByIce(bulletinPaie.getEntreprise().getIce());
            bulletinPaie.setEntreprise(entreprise);

            // Fetch and set rubriques for each bulletinPaieRubrique
            List<BulletinPaieRubrique> bulletinPaieRubriques = bulletinPaie.getBulletinPaieRubriques();
            for (BulletinPaieRubrique bpRubrique : bulletinPaieRubriques) {
                Rubrique rubrique = rubriqueService.findByCode(bpRubrique.getRubrique().getCode());
                bpRubrique.setRubrique(rubrique);
                bpRubrique.setBulletinPaie(bulletinPaie);
            }
        }

        return allBps;
    }
*/


    @Override
    @Transactional
    public int deleteByEmployeMatricule(Long matricule) {
        return bulletinPaieDao.deleteByEmployeMatricule(matricule);
    }



    @Override
    public int save(BulletinPaie bulletinPaie) {
        Employe employe = employeService.findByMatricule(bulletinPaie.getEmploye().getMatricule());
        if (employe == null) {
            return -2;
        }
        bulletinPaie.setEmploye(employe);

        Entreprise entreprise = entrepriseService.findByIce(bulletinPaie.getEntreprise().getIce());
        if (entreprise == null) {
            return -3;
        }
        bulletinPaie.setEntreprise(entreprise);

        BulletinPaie existingBulletin = findByCode(bulletinPaie.getCode());
        if (existingBulletin != null) {
            return -1;
        }

        bulletinPaieDao.save(bulletinPaie);

        Set<BulletinPaieRubrique> bulletinPaieRubriques = bulletinPaie.getBulletinPaieRubriques();
        for (BulletinPaieRubrique bpRubrique : bulletinPaieRubriques) {
            Rubrique rubrique = rubriqueService.findByCode(bpRubrique.getRubrique().getCode());
            if (rubrique == null) {
                return -4;
            }
            bpRubrique.setBulletinPaie(bulletinPaie);
            bpRubrique.setRubrique(rubrique);

            // Ensure the BulletinPaieRubriqueKey is properly initialized
            BulletinPaieRubriqueKey key = new BulletinPaieRubriqueKey();
            key.setBulletinPaieId(bulletinPaie.getId());
            key.setRubriqueId(rubrique.getId());
            bpRubrique.setId(key);

            bulletinPaieRubriqueDao.save(bpRubrique);
        }

        return 1;
    }

    @Override
    public Resource toPdf(BulletinPaie bulletinPaie) throws IOException {
        BulletinPaie bulletin = findByCode(bulletinPaie.getCode());
        return PdfUtil.htmlToPdf(bulletin, templateEngine, "bulletinPaie");
    }

    @Override
    public Resource getPdfByCode(String code) throws IOException {
         BulletinPaie bulletinPaie = findByCode(Long.valueOf(code));
        if (bulletinPaie == null) {
            throw new IOException("BulletinPaie not found with code: " + code);
        }
        return toPdf(bulletinPaie);
    }

    public BigDecimal salBaseToSalBasMen(BulletinPaie bulletinPaie) {
        Employe employe = employeService.findByMatricule(bulletinPaie.getEmploye().getMatricule());
        int newNbrJourTravaille = bulletinPaie.getNbrJourTravaille() - (bulletinPaie.getNbrJourCongeNonPaye()) - (bulletinPaie.getNbrJourAbsenceNonJust());
        BigDecimal salaireBase = employe.getSalaire();
        bulletinPaie.setNbrJourTravaille(newNbrJourTravaille);
        return salaireBase.multiply(new BigDecimal(newNbrJourTravaille)).divide(new BigDecimal(employe.getNbrJourTravaille()), 2, RoundingMode.HALF_UP);
    }


    public BigDecimal salBasMenToSalBasImp(BulletinPaie bulletinPaie) {
        BigDecimal heuresSupp25 = BigDecimal.ZERO;
        BigDecimal heuresSupp50 = BigDecimal.ZERO;
        BigDecimal heuresSupp100 = BigDecimal.ZERO;
        BigDecimal taux = BigDecimal.ZERO; // Default value

        for (BulletinPaieRubrique bpRubrique : bulletinPaie.getBulletinPaieRubriques()) {
            Long code = bpRubrique.getRubrique().getCode();
           if (code == 16) {
                taux = new BigDecimal("1.25");
               heuresSupp25 = bpRubrique.getNombre().multiply(bulletinPaie.getTauxHoraire()).multiply(taux);
               bulletinPaie.setHeuresSupp25(heuresSupp25.setScale(2, RoundingMode.HALF_UP));
            } else if (code == 17) {
                taux = new BigDecimal("1.5");
               heuresSupp50 = bpRubrique.getNombre().multiply(bulletinPaie.getTauxHoraire()).multiply(taux);
               bulletinPaie.setHeuresSupp50(heuresSupp50.setScale(2, RoundingMode.HALF_UP));
            } else if (code == 18) {
                taux = new BigDecimal("2");
               heuresSupp100 = bpRubrique.getNombre().multiply(bulletinPaie.getTauxHoraire()).multiply(taux);
               bulletinPaie.setHeuresSupp100(heuresSupp100.setScale(2, RoundingMode.HALF_UP));
            }
            BigDecimal salaireBaseImp = bulletinPaie.getSalaireBaseMensuelle().add(heuresSupp25).add(heuresSupp50).add(heuresSupp100);
            bulletinPaie.setSalaireBaseImposable(salaireBaseImp.setScale(2, RoundingMode.HALF_UP));
        }

        return bulletinPaie.getSalaireBaseImposable();
    }


    private Map<Long, BigDecimal> montantMaxForCode = Map.of(
            1L, BigDecimal.valueOf(100),
            2L, BigDecimal.valueOf(200),
            3L, BigDecimal.valueOf(100),
            4L, BigDecimal.valueOf(150),
            5L, BigDecimal.valueOf(500),
            6L, BigDecimal.valueOf(1500),
            7L, BigDecimal.valueOf(150),
            8L, BigDecimal.valueOf(150)
    );

    public List<BulletinPaieRubrique> nonImposableToImposable(List<BulletinPaieRubrique> bpRubriques) {
        for (BulletinPaieRubrique bpRubrique : bpRubriques) {
            Rubrique rubrique = rubriqueService.findByCode(bpRubrique.getRubrique().getCode());
            bpRubrique.setRubrique(rubrique);
            if (!rubrique.getImposable()) {
                BigDecimal maxMontant = montantMaxForCode.get(rubrique.getCode());
                if (maxMontant != null && bpRubrique.getMontant().compareTo(maxMontant) > 0) {
                    rubrique.setImposable(true);
                }
            }
        }
        return bpRubriques;
    }

    public double primeAnciennete(int anciennete) {
        double tauxAnc;
        if (anciennete >= 0 && anciennete < 2) {
            tauxAnc = 0;
        } else if (anciennete >= 2 && anciennete < 5) {
            tauxAnc = 0.05;
        } else if (anciennete >= 5 && anciennete < 12) {
            tauxAnc = 0.1;
        } else if (anciennete >= 12 && anciennete < 20) {
            tauxAnc = 0.15;
        } else if (anciennete >= 20 && anciennete < 25) {
            tauxAnc = 0.2;
        } else {
            tauxAnc = 0.25;
        }
        return tauxAnc;
    }


    public BigDecimal salBasImpToSalBrutG(BulletinPaie bulletinPaie) {
        BigDecimal salaireBaseImposable = bulletinPaie.getSalaireBaseImposable();
        BigDecimal tauxAnc = new BigDecimal(primeAnciennete(bulletinPaie.getAnciennete()));
        BigDecimal primeAnc = salaireBaseImposable.multiply(tauxAnc);
        salaireBaseImposable = salaireBaseImposable.add(primeAnc);
        tauxAnc = tauxAnc.multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setTauxAnc(tauxAnc);
        primeAnc = primeAnc.setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setPrimeAnc(primeAnc);
        for (BulletinPaieRubrique bpRubrique : bulletinPaie.getBulletinPaieRubriques()) {
            Rubrique rubrique = bpRubrique.getRubrique();
            if (rubrique.getCode() == 11 || rubrique.getCode() == 16 || rubrique.getCode() == 17 || rubrique.getCode() == 18) {
                continue;
            }
            BigDecimal montantRubrique = bpRubrique.getMontant();
            salaireBaseImposable = salaireBaseImposable.add(montantRubrique);
        }

        return salaireBaseImposable;
    }


    public BigDecimal salBrutGToSalBrutImp(BulletinPaie bulletinPaie) {
        BigDecimal salaireBrutGlobale = bulletinPaie.getSalaireBruteGlobale();
        List<BulletinPaieRubrique> bpRubriques = new ArrayList<>(bulletinPaie.getBulletinPaieRubriques());
        bpRubriques = nonImposableToImposable(bpRubriques);
        for (BulletinPaieRubrique bpRubrique : bpRubriques) {
            Rubrique rubrique = bpRubrique.getRubrique();
            if (!rubrique.getImposable()) {
                salaireBrutGlobale = salaireBrutGlobale.subtract(bpRubrique.getMontant());
            }
        }
        return salaireBrutGlobale;
    }


    public BigDecimal salBrutImpToSalNetImp(BulletinPaie bulletinPaie) {
        BigDecimal cnss;
        BigDecimal fraisPro;
        BigDecimal cnssPlafond = new BigDecimal(6000);
        BigDecimal tauxCnss = new BigDecimal("0.0448");
        BigDecimal tauxAmo = new BigDecimal("0.0226");
        BigDecimal tauxFraisPro1 = new BigDecimal("0.35");
        BigDecimal tauxFraisPro2 = new BigDecimal("0.25");
        BigDecimal fpPlafond1 = new BigDecimal(2275);
        BigDecimal fpPlafond2 = new BigDecimal("2916.67");
        if (bulletinPaie.getSalaireBrutImp().compareTo(cnssPlafond) <= 0) {
            cnss = bulletinPaie.getSalaireBrutImp().multiply(tauxCnss);
        } else {
            cnss = cnssPlafond.multiply(tauxCnss);
        }
        cnss = cnss.setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setRetenusCnss(cnss);
        BigDecimal amo = bulletinPaie.getSalaireBrutImp().multiply(tauxAmo);
        amo = amo.setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setRetenusAmo(amo);
        if (bulletinPaie.getSalaireBrutImp().compareTo(new BigDecimal(6500)) <= 0) {
            fraisPro = bulletinPaie.getSalaireBrutImp().multiply(tauxFraisPro1);
            if (fraisPro.compareTo(fpPlafond1) >= 0) {
                fraisPro = fpPlafond1;
            }
        } else {
            fraisPro = bulletinPaie.getSalaireBrutImp().multiply(tauxFraisPro2);
            if (fraisPro.compareTo(fpPlafond2) >= 0) {
                fraisPro = fpPlafond1;
            }
        }
        return bulletinPaie.getSalaireBrutImp().subtract(cnss).subtract(amo).subtract(fraisPro);
    }

    public static BigDecimal calculIrBrut(BulletinPaie bulletinPaie) {
        BigDecimal salaireNetImp = bulletinPaie.getSalaireNetImp();
        BigDecimal tauxIr = BigDecimal.ZERO;
        BigDecimal deduction = BigDecimal.ZERO;
        BigDecimal irBrut;
        if (salaireNetImp.compareTo(new BigDecimal("2501")) >= 0 && salaireNetImp.compareTo(new BigDecimal("4166")) <= 0) {
            tauxIr = new BigDecimal("0.1");
            deduction = new BigDecimal("250");
        } else if (salaireNetImp.compareTo(new BigDecimal("4167")) >= 0 && salaireNetImp.compareTo(new BigDecimal("5000")) <= 0) {
            tauxIr = new BigDecimal("0.2");
            deduction = new BigDecimal("666.67");
        } else if (salaireNetImp.compareTo(new BigDecimal("5001")) >= 0 && salaireNetImp.compareTo(new BigDecimal("6666")) <= 0) {
            tauxIr = new BigDecimal("0.3");
            deduction = new BigDecimal("1166.67");
        } else if (salaireNetImp.compareTo(new BigDecimal("6667")) >= 0 && salaireNetImp.compareTo(new BigDecimal("15000")) <= 0) {
            tauxIr = new BigDecimal("0.34");
            deduction = new BigDecimal("1433.33");
        } else if (salaireNetImp.compareTo(new BigDecimal("15001")) >= 0) {
            tauxIr = new BigDecimal("0.38");
            deduction = new BigDecimal("2033.33");
        }
        tauxIr = tauxIr.setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setTauxIr(tauxIr.multiply(new BigDecimal(100)));
        return salaireNetImp.multiply(tauxIr).subtract(deduction);
    }

    public BigDecimal calculIrNet(BulletinPaie bulletinPaie) {
        BigDecimal irBrut = calculIrBrut(bulletinPaie);
        BigDecimal retenusIr = BigDecimal.ZERO;
        Employe employe = employeService.findByMatricule(bulletinPaie.getEmploye().getMatricule());
        int chargeFamilles = (employe.getNbrDeduction()) * 30;
        if (employe.getNbrDeduction() >= 7) {
            chargeFamilles = 180;
        }
        if (irBrut.compareTo(new BigDecimal(chargeFamilles)) > 0) {
            retenusIr = irBrut.subtract(new BigDecimal(chargeFamilles));
        }
        retenusIr = retenusIr.setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setRetenusIr(retenusIr);
        return bulletinPaie.getRetenusIr();
    }

    public BigDecimal salNetImpTosalNetPayer(BulletinPaie bulletinPaie) {
        BigDecimal irNet = calculIrNet(bulletinPaie);
        bulletinPaie.setRetenusIr(irNet);
        return bulletinPaie.getSalaireBruteGlobale().subtract(bulletinPaie.getRetenusCnss()).subtract(bulletinPaie.getRetenusAmo()).subtract(bulletinPaie.getRetenusIr());

    }

    public BulletinPaie salBaseTosalNetPayer(BulletinPaie bulletinPaie) /*throws IOException */{
        Employe employe = employeService.findByMatricule(bulletinPaie.getEmploye().getMatricule());
        bulletinPaie.setEmploye(employe);
        Entreprise entreprise = entrepriseService.findByIce(bulletinPaie.getEntreprise().getIce());
        bulletinPaie.setEntreprise(entreprise);
        List<BulletinPaieRubrique> bulletinPaieRubriques = new ArrayList<>(bulletinPaie.getBulletinPaieRubriques());
        for (BulletinPaieRubrique bpRubrique : bulletinPaieRubriques) {
            Rubrique rubrique = rubriqueService.findByCode(bpRubrique.getRubrique().getCode());
            bpRubrique.setBulletinPaie(bulletinPaie);
            bpRubrique.setRubrique(rubrique);
        }
        BigDecimal salBaseMen = salBaseToSalBasMen(bulletinPaie).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setSalaireBaseMensuelle(salBaseMen);

        salBasMenToSalBasImp(bulletinPaie);


        BigDecimal salBrutGlobal = salBasImpToSalBrutG(bulletinPaie).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setSalaireBruteGlobale(salBrutGlobal);

        BigDecimal salBrutImp = salBrutGToSalBrutImp(bulletinPaie).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setSalaireBrutImp(salBrutImp);

        BigDecimal salNetImp = salBrutImpToSalNetImp(bulletinPaie).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setSalaireNetImp(salNetImp);

        BigDecimal salNetAPayer = salNetImpTosalNetPayer(bulletinPaie).setScale(2, RoundingMode.HALF_UP);
        bulletinPaie.setSalNetPayer(salNetAPayer);
      return  bulletinPaie;
    }

    public BulletinPaieDto bulletinCalculated(BulletinPaie bulletinPaie){
        salBaseTosalNetPayer(bulletinPaie);
        BulletinPaieDto bulletinPaieDto = bulletinCalculeConverter.bulletinToBulletinDto(bulletinPaie);
        return  bulletinPaieDto;
    }
    public int saveBulletin(BulletinPaie bulletinPaie){
        salBaseTosalNetPayer(bulletinPaie);
        int response = save(bulletinPaie);
        if (response == -1) {
            return-1;
        } else if (response == -2) {
            return-2;
        }
        else if (response == -3) {
            return-3;
        }
        else if (response == -4) {
            return-4;
        }
        return 1;
    }
}




