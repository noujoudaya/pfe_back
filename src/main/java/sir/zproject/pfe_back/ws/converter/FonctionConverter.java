package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.ws.dto.DepartementDto;
import sir.zproject.pfe_back.ws.dto.FonctionDto;

import java.util.List;

@Component
public class FonctionConverter {
    public Fonction toBean(FonctionDto dto) {
        Fonction bean = new Fonction();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        bean.setService(dto.getService());
        return bean;
    }

    public List<Fonction> toBean(List<FonctionDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }

    public FonctionDto toDto(Fonction bean) {
        FonctionDto dto = new FonctionDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        dto.setService(bean.getService());
        return dto;
    }

    public List<FonctionDto> toDto(List<Fonction> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
