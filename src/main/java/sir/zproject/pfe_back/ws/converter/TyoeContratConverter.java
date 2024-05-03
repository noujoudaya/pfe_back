package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.TypeContrat;
import sir.zproject.pfe_back.ws.dto.DepartementDto;
import sir.zproject.pfe_back.ws.dto.TypeContratDto;

import java.util.List;

@Component
public class TyoeContratConverter {
    public TypeContrat toBean(TypeContratDto dto) {
        TypeContrat bean = new TypeContrat();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        bean.setTypeSalaire(dto.getTypeSalaire());
        return bean;
    }

    public List<TypeContrat> toBean(List<TypeContratDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }

    public TypeContratDto toDto(TypeContrat bean) {
        TypeContratDto dto = new TypeContratDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        dto.setTypeSalaire(bean.getTypeSalaire());
        return dto;
    }

    public List<TypeContratDto> toDto(List<TypeContrat> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
