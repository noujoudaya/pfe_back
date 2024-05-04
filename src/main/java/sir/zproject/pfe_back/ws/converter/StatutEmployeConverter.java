package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;

import sir.zproject.pfe_back.bean.StatutEmploye;

import sir.zproject.pfe_back.ws.dto.StatutEmployeDto;

import java.util.List;

@Component
public class StatutEmployeConverter {
    public StatutEmploye toBean(StatutEmployeDto dto) {
        StatutEmploye bean = new StatutEmploye();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        return bean;
    }

    public List<StatutEmploye> toBean(List<StatutEmployeDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }

    public StatutEmployeDto toDto(StatutEmploye bean) {
        StatutEmployeDto dto = new StatutEmployeDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        return dto;
    }

    public List<StatutEmployeDto> toDto(List<StatutEmploye> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
