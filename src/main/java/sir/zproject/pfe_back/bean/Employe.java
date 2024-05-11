package sir.zproject.pfe_back.bean;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.deserializers.*;
import sir.zproject.pfe_back.enumeration.*;
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
    private long numeroCNSS;

    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateEntree;
    private LocalDate dateFinContrat;

    private BigDecimal salaire;
    private BigDecimal soldeConge;

    @JsonDeserialize(using = DesignationDeserializer.class)
    @Enumerated(EnumType.STRING)
    private DESIGNATION designation;

    @JsonDeserialize(using = GenreDeserializer.class)
    @Enumerated(EnumType.STRING)
    private GENRE genre;

    @JsonDeserialize(using = SituationFamilialeDeserializer.class)
    @Enumerated(EnumType.STRING)
    private SITUATION_FAMILIALE situationFamiliale;


    @JsonDeserialize(using = StatutEmployeDeserialize.class)
    @Enumerated(EnumType.STRING)
    private StatutEmploye statutEmploye;

    @JsonDeserialize(using = TypeSalaireDeserializer.class)
    @Enumerated(EnumType.STRING)
    private TYPE_SALAIRE typeSalaire;

    @JsonDeserialize(using = TypeContratDeserializer.class)
    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;

    @ManyToOne
    private Fonction fonction;
    @ManyToOne
    private Service service;
    @ManyToOne
    private Departement departement;


}

