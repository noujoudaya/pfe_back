package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class BulletinPaieDto {
    private Long id;
    private Long code;
    private String month;
    private int year;
    private int  nbrJourTravaille;
    private int  nbrHeuresTravaille;
    private BigDecimal tauxHoraire;
    private int  nbrJourCongeNonPaye;
    private int  nbrJourAbsenceNonJust;
    private int  anciennete;
    private BigDecimal salaireBaseMensuelle;
    private BigDecimal salaireBaseImposable;
    private BigDecimal salaireBruteGlobale;
    private BigDecimal salaireBrutImp;
    private BigDecimal salaireNetImp;
    private BigDecimal salNetPayer;
    private BigDecimal retenusCnss;
    private BigDecimal retenusAmo;
    private BigDecimal retenusIr;
    private BigDecimal tauxIr;
    private List<BulletinPaieRubriqueDto> bulletinPaieRubriques;
    private EmployeDto employe;
    private EntrepriseDto entreprise;
    private BigDecimal tauxAnc;
    private BigDecimal primeAnc;
    private BigDecimal  heuresSupp25;
    private BigDecimal  heuresSupp50;
    private BigDecimal  heuresSupp100;

}
