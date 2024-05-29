package sir.zproject.pfe_back.ws.converter;



import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.BulletinPaieRubrique;
import sir.zproject.pfe_back.bean.Rubrique;
import sir.zproject.pfe_back.ws.dto.BulletinPaieRubriqueDto;
import sir.zproject.pfe_back.ws.dto.RubriqueDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RubriqueConverter {

    public Rubrique toBean(RubriqueDto dto) {
        Rubrique bean = new Rubrique();

        bean.setCode(dto.getCode());
        bean.setImposable(dto.getImposable());
        bean.setLibelle(dto.getLibelle());


        return bean;
    }
    public List<Rubrique> toBean(List<RubriqueDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }
    public RubriqueDto toDto(Rubrique bean) {
        RubriqueDto dto = new RubriqueDto();

        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        dto.setImposable(bean.getImposable());
        return dto;

    }
    public List<RubriqueDto> toDto(List<Rubrique> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
