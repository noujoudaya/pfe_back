package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DemandeConge {
    @Id
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateDemande;
    private StatutConge statutConge;
    @ManyToOne
    private TypeConge typeConge;
}

