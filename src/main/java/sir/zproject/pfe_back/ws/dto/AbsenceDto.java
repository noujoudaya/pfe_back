package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAbsence;

import java.time.LocalDate;

@Getter
@Setter
public class AbsenceDto {

    private Long id;
    private Employe employe;
    private LocalDate dateAbsence;
    private StatutAbsence statutAbsence;


}
