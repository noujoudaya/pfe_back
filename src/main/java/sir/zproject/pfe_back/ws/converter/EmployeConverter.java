package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.ws.dto.EmployeDto;

@Component
public class EmployeConverter {
    public EmployeDto toDto(Employe employe) {
        return new EmployeDto();
    }
}
