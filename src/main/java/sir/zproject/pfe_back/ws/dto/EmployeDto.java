package sir.zproject.pfe_back.ws.dto;


import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.StatutEmploye;
import sir.zproject.pfe_back.bean.TypeContrat;
import sir.zproject.pfe_back.enumeration.DESIGNATION;
import sir.zproject.pfe_back.enumeration.GENRE;
import sir.zproject.pfe_back.enumeration.SITUATION_FAMILIALE;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeDto {
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

    private DESIGNATION designation;
    private GENRE genre;
    private SITUATION_FAMILIALE situationFamiliale;

    private StatutEmploye statutEmploye;
    private TypeContrat typeContrat;

}
