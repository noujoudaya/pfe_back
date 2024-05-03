package sir.zproject.pfe_back.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.ws.dto.AbsenceDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AbsenceConverter {

    @Autowired
    private EmployeConverter employeConverter;

    public AbsenceDto toDto(Absence absence) {

        AbsenceDto absenceDto = new AbsenceDto();
        absenceDto.setId(absence.getId());
        absenceDto.setEmploye(absence.getEmploye());
        absenceDto.setDateAbsence(absence.getDateAbsence());
        absenceDto.setStatutAbsence(absence.getStatutAbsence());
        return absenceDto;
    }

    public Absence toBean(AbsenceDto absenceDto) {

        Absence absence = new Absence();
        absence.setId(absenceDto.getId());
        absence.setEmploye(absenceDto.getEmploye());
        absence.setDateAbsence(absenceDto.getDateAbsence());
        absence.setStatutAbsence(absenceDto.getStatutAbsence());
        return absence;
    }

    public List<Absence> toBean(List<AbsenceDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }

    public List<AbsenceDto> toDto(List<Absence> commandes) {
        return commandes.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

}
