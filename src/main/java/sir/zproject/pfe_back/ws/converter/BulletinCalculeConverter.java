package sir.zproject.pfe_back.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.BulletinPaie;
import sir.zproject.pfe_back.bean.BulletinPaieRubrique;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Rubrique;
import sir.zproject.pfe_back.dao.BulletinPaieRubriqueDao;
import sir.zproject.pfe_back.ws.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BulletinCalculeConverter {
    @Autowired
    private EmployeConverter employeConverter;
    @Autowired
    private EntrepriseConverter entrepriseConverter;
    public BulletinPaieDto bulletinToBulletinDto(BulletinPaie bulletinPaie) {
        BulletinPaieDto dto = new BulletinPaieDto();
        dto.setCode(bulletinPaie.getCode());
        dto.setMonth(bulletinPaie.getMonth());
        dto.setAnciennete(bulletinPaie.getAnciennete());
        dto.setEmploye(employeConverter.toDto(bulletinPaie.getEmploye()));
        dto.setEntreprise(entrepriseConverter.toDto(bulletinPaie.getEntreprise()));
        dto.setYear(bulletinPaie.getYear());
        dto.setNbrHeuresTravaille(bulletinPaie.getNbrHeuresTravaille());
        dto.setRetenusAmo(bulletinPaie.getRetenusAmo());
        dto.setNbrJourTravaille(bulletinPaie.getNbrJourTravaille());
        dto.setRetenusCnss(bulletinPaie.getRetenusCnss());
        dto.setRetenusIr(bulletinPaie.getRetenusIr());
        dto.setTauxIr(bulletinPaie.getTauxIr());
        dto.setTauxHoraire(bulletinPaie.getTauxHoraire());
        dto.setNbrHeuresTravaille(bulletinPaie.getNbrHeuresTravaille());
        dto.setNbrJourAbsenceNonJust(bulletinPaie.getNbrJourAbsenceNonJust());
        dto.setNbrJourCongeNonPaye(bulletinPaie.getNbrJourCongeNonPaye());
        dto.setSalaireBaseImposable(bulletinPaie.getSalaireBaseImposable());
        dto.setSalaireBaseMensuelle(bulletinPaie.getSalaireBaseMensuelle());
        dto.setSalaireBruteGlobale(bulletinPaie.getSalaireBruteGlobale());
        dto.setSalNetPayer(bulletinPaie.getSalNetPayer());
        dto.setSalaireBrutImp(bulletinPaie.getSalaireBrutImp());
        dto.setSalaireNetImp(bulletinPaie.getSalaireNetImp());
        dto.setPrimeAnc(bulletinPaie.getPrimeAnc());
        dto.setTauxAnc(bulletinPaie.getTauxAnc());
        dto.setHeuresSupp25(bulletinPaie.getHeuresSupp25());
        dto.setHeuresSupp50(bulletinPaie.getHeuresSupp50());
        dto.setHeuresSupp100(bulletinPaie.getHeuresSupp100());
       dto.setBulletinPaieRubriques(bulletinPaieRubriqueTobulletinPaieRubriqueDto(bulletinPaie.getBulletinPaieRubriques()));

        return dto;
    }
    public BulletinPaieRubriqueDto bulletinPaieRubriqueTobulletinPaieRubriqueDto(BulletinPaieRubrique bulletinPaieRubrique){
        BulletinPaieRubriqueDto dto = new BulletinPaieRubriqueDto();
        dto.setBulletinPaieId(bulletinPaieRubrique.getBulletinPaie().getId());
        dto.setRubriqueId(bulletinPaieRubrique.getRubrique().getId());
        dto.setRubrique(rubriqueToRubriqueDto(bulletinPaieRubrique.getRubrique()));
        dto.setMontant(bulletinPaieRubrique.getMontant());
        return dto;
    }
    public List<BulletinPaieRubriqueDto> bulletinPaieRubriqueTobulletinPaieRubriqueDto(Set<BulletinPaieRubrique> bprs) {
        return bprs.stream().map(this::bulletinPaieRubriqueTobulletinPaieRubriqueDto).toList();

    }

    public RubriqueDto rubriqueToRubriqueDto(Rubrique rubrique){
        RubriqueDto dto = new RubriqueDto();
        dto.setId(rubrique.getId());
        dto.setImposable(rubrique.getImposable());
        dto.setLibelle(rubrique.getLibelle());
        dto.setCode(rubrique.getCode());
        return dto;
    }
}
