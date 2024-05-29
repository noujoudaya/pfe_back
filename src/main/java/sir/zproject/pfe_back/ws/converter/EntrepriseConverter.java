package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;



import sir.zproject.pfe_back.bean.Entreprise;

import sir.zproject.pfe_back.ws.dto.EntrepriseDto;

import java.util.List;


@Component
public class EntrepriseConverter {
    public Entreprise toBean(EntrepriseDto dto) {
        Entreprise bean = new Entreprise();
                bean.setId(dto.getId());
                bean.setIce(dto.getIce());
                bean.setAdresse(dto.getAdresse());
                bean.setNumeroCNSS(dto.getNumeroCNSS());
                bean.setIdentifiantFiscale(dto.getIdentifiantFiscale());
                bean.setRaisonSociale(dto.getRaisonSociale());
                bean.setNumeromutuelle(dto.getNumeromutuelle());

        return bean;
    }
    public List<Entreprise> toBean(List<EntrepriseDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }
    public EntrepriseDto toDto(Entreprise bean) {
        EntrepriseDto dto = new EntrepriseDto();
        dto.setId(bean.getId());
        dto.setIce(bean.getIce());
        dto.setAdresse(bean.getAdresse());
        dto.setNumeroCNSS(bean.getNumeroCNSS());
        dto.setIdentifiantFiscale(bean.getIdentifiantFiscale());
        dto.setRaisonSociale(bean.getRaisonSociale());
        dto.setNumeromutuelle(bean.getNumeromutuelle());

        return dto;
        
    }
    public List<EntrepriseDto> toDto(List<Entreprise> beans) {
        return beans.stream().map(this::toDto).toList();

    }
}
