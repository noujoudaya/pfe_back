package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutConge;
import sir.zproject.pfe_back.bean.TypeConge;

import java.time.LocalDate;
@Getter
@Setter
public class DemandeCongeDto {
    private Long id;
    private Employe employe;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateDemande;
    private StatutConge statutConge;
    private TypeConge typeConge;
    private String motifRefus;
}

