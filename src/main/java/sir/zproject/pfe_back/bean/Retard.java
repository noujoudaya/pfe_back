package sir.zproject.pfe_back.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.StatutAbsence;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Retard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateRetard;
    private LocalTime heureDebutTravail;
    private LocalTime heureArrivee;
    private StatutAbsence statutRetard;
}
