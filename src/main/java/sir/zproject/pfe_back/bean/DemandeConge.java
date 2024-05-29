package sir.zproject.pfe_back.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.StatutConge;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class DemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateDemande;
    private StatutConge statutConge;
    @ManyToOne
    private TypeConge typeConge;
    private String motifRefus;
}

