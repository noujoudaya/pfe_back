package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.ws.dto.EmployeDto;

import java.util.List;

@Component
public class EmployeConverter {
    public Employe toBean(EmployeDto dto) {
        Employe bean = new Employe();
        bean.setId(dto.getId());
        bean.setNom(dto.getNom());
        bean.setPrenom(dto.getPrenom());
        bean.setAdresse(dto.getAdresse());
        bean.setCin(dto.getCin());
        bean.setEmail(dto.getEmail());
        bean.setDateEmbauche(dto.getDateEmbauche());
        bean.setDateEntree(dto.getDateEntree());
        bean.setDateFinContrat(dto.getDateFinContrat());
        bean.setDateNaissance(dto.getDateNaissance());
        bean.setDesignation(dto.getDesignation());
        bean.setGenre(dto.getGenre());
        bean.setSalaire(dto.getSalaire());
        bean.setSituationFamiliale(dto.getSituationFamiliale());
        bean.setSoldeConge(dto.getSoldeConge());
        bean.setNumeroCompteBancaire(dto.getNumeroCompteBancaire());
        bean.setNumeroCNSS(dto.getNumeroCNSS());
        bean.setStatutEmploye(dto.getStatutEmploye());
        bean.setTelephone(dto.getTelephone());
        bean.setTypeContrat(dto.getTypeContrat());
        bean.setTypeSalaire(dto.getTypeSalaire());
        bean.setVille(dto.getVille());
        bean.setDepartement(dto.getDepartement());
        bean.setService(dto.getService());
        bean.setFonction(dto.getFonction());
        return bean;
    }
    public List<Employe> toBean(List<EmployeDto> dtos) {
        return dtos.stream().map(this::toBean).toList();
    }
    public EmployeDto toDto(Employe bean) {
        EmployeDto dto = new EmployeDto();
        dto.setId(bean.getId());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setAdresse(bean.getAdresse());
        dto.setCin(bean.getCin());
        dto.setEmail(bean.getEmail());
        dto.setDateEmbauche(bean.getDateEmbauche());
        dto.setDateEntree(bean.getDateEntree());
        dto.setDateFinContrat(bean.getDateFinContrat());
        dto.setDateNaissance(bean.getDateNaissance());
        dto.setDesignation(bean.getDesignation());
        dto.setGenre(bean.getGenre());
        dto.setSalaire(bean.getSalaire());
        dto.setSituationFamiliale(bean.getSituationFamiliale());
        dto.setSoldeConge(bean.getSoldeConge());
        dto.setNumeroCompteBancaire(bean.getNumeroCompteBancaire());
        dto.setNumeroCNSS(bean.getNumeroCNSS());
        dto.setStatutEmploye(bean.getStatutEmploye());
        dto.setTelephone(bean.getTelephone());
        dto.setTypeContrat(bean.getTypeContrat());
        dto.setTypeSalaire(bean.getTypeSalaire());
        dto.setVille(bean.getVille());
        dto.setDepartement(bean.getDepartement());
        dto.setService(bean.getService());
        dto.setFonction(bean.getFonction());
        return dto;
    }
    public List<EmployeDto> toDto(List<Employe> beans) {
        return beans.stream().map(this::toDto).toList();

    }

}