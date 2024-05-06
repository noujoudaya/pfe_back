package sir.zproject.pfe_back.bean;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.DESIGNATION;
import sir.zproject.pfe_back.enumeration.GENRE;
import sir.zproject.pfe_back.enumeration.SITUATION_FAMILIALE;
import sir.zproject.pfe_back.security.user.User;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Employe extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String cin;
    private String ville;
    private String numeroCompteBancaire;

    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateEntree;
    private LocalDate dateFinContrat;

    private BigDecimal salaire;
    private BigDecimal soldeConge;
    @JsonDeserialize(using = DesignationDeserializer.class)
    @Enumerated(EnumType.STRING)
    private DESIGNATION designation;
    @Enumerated(EnumType.STRING)
    private GENRE genre;
    @JsonDeserialize(using = SituationFamilialeDeserializer.class)
    @Enumerated(EnumType.STRING)
    private SITUATION_FAMILIALE situationFamiliale;
    @ManyToOne
    private StatutEmploye statutEmploye;
    @ManyToOne
    private TypeContrat typeContrat;
    @ManyToOne
    private Fonction fonction;



}

