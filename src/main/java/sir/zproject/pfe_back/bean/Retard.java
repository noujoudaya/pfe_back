package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Retard {

    @Id
    private Long id;
    @ManyToOne
    private Employe employe;
    private LocalDate dateRetard;
    private LocalTime heureDebutTravail;
    private LocalTime heureArrivee;
}
