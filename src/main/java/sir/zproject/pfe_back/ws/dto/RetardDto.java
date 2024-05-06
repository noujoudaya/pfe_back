package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Employe;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class RetardDto {
    private Long id;
    private Employe employe;
    private LocalDate dateRetard;
    private LocalTime heureDebutTravail;
    private LocalTime heureArrivee;
}
