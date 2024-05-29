package sir.zproject.pfe_back.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class BulletinPaie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    @ManyToOne
    private Employe employe;
    @ManyToOne
    private Entreprise entreprise;


    private String month;


    private int year;
    private int  nbrJourTravaille;
    private int  nbrHeuresTravaille;
    private BigDecimal tauxHoraire;
    private int  nbrJourCongeNonPaye;
    private int  nbrJourAbsenceNonJust;
    private int  anciennete;
    private BigDecimal  heuresSupp25;
    private BigDecimal  heuresSupp50;
    private BigDecimal  heuresSupp100;

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
   private BigDecimal tauxAnc;
   private BigDecimal primeAnc;

    @OneToMany(mappedBy = "bulletinPaie",fetch = FetchType.EAGER )
    private   Set<BulletinPaieRubrique> bulletinPaieRubriques;

    public BulletinPaie() {

        this.year = 0;
        this.nbrJourTravaille = 0;
        this.nbrHeuresTravaille = 0;

        this.tauxHoraire = BigDecimal.ZERO;
        this.nbrJourCongeNonPaye = 0;
        this.nbrJourAbsenceNonJust = 0;
        this.anciennete = 0;
        this.salaireBaseMensuelle = BigDecimal.ZERO;
        this.salaireBaseImposable = BigDecimal.ZERO;
        this.salaireBruteGlobale = BigDecimal.ZERO;
        this.salaireBrutImp = BigDecimal.ZERO;
        this.salaireNetImp = BigDecimal.ZERO;
        this.salNetPayer = BigDecimal.ZERO;
        this.retenusCnss = BigDecimal.ZERO;
        this.retenusAmo = BigDecimal.ZERO;
        this.retenusIr = BigDecimal.ZERO;
        this.tauxIr = BigDecimal.ZERO;
        this.heuresSupp25 = BigDecimal.ZERO;
        this.heuresSupp50 = BigDecimal.ZERO;
        this.heuresSupp100 = BigDecimal.ZERO;
    }
}
