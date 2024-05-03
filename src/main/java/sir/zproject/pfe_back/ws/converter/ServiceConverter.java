package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.ws.dto.DepartementDto;
import sir.zproject.pfe_back.ws.dto.FonctionDto;
import sir.zproject.pfe_back.ws.dto.ServiceDto;

import java.util.List;

@Component
public class ServiceConverter {
    public Service toBean(ServiceDto dto) {
        Service bean = new Service();
        bean.setId(dto.getId());
        bean.setCode(dto.getCode());
        bean.setLibelle(dto.getLibelle());
        bean.setDepartement(dto.getDepartement());
        return bean;
    }

    public List<Service> toBean(List<ServiceDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }

    public ServiceDto toDto(Service bean) {
        ServiceDto dto = new ServiceDto();
        dto.setId(bean.getId());
        dto.setCode(bean.getCode());
        dto.setLibelle(bean.getLibelle());
        dto.setDepartement(bean.getDepartement());
        return dto;
    }

    public List<ServiceDto> toDto(List<Service> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
