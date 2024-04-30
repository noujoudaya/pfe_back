package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.TypeConge;
import sir.zproject.pfe_back.ws.dto.TypeCongeDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeCongeConverter {

    public TypeCongeDto toDto(TypeConge typeConge) {

        TypeCongeDto typeCongeDto = new TypeCongeDto();
        typeCongeDto.setId(typeConge.getId());
        typeCongeDto.setLibelle(typeConge.getLibelle());
        typeCongeDto.setCode(typeConge.getCode());
        return typeCongeDto;

    }

    public TypeConge toBean(TypeCongeDto typeCongeDto) {

        TypeConge typeConge = new TypeConge();
        typeConge.setId(typeCongeDto.getId());
        typeConge.setLibelle(typeCongeDto.getLibelle());
        typeConge.setCode(typeCongeDto.getCode());
        return typeConge;
    }

    public List<TypeConge> toBean(List<TypeCongeDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }


    public List<TypeCongeDto> toDto(List<TypeConge> commandes) {
        return commandes.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

}
