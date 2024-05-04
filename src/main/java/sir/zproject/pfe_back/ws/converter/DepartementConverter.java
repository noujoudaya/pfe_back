package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.ws.dto.DepartementDto;

import java.util.List;

@Component
public class DepartementConverter {
    public Departement toBean(DepartementDto dto) {
        Departement bean = new Departement();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        return bean;
    }

    public List<Departement> toBean(List<DepartementDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }

    public DepartementDto toDto(Departement bean) {
        DepartementDto dto = new DepartementDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        return dto;
    }

    public List<DepartementDto> toDto(List<Departement> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
