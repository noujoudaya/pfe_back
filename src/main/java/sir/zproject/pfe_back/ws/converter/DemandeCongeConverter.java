package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.ws.dto.DemandeAttestationDto;
import sir.zproject.pfe_back.ws.dto.DemandeCongeDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DemandeCongeConverter {

    public DemandeCongeDto toDto(DemandeConge demandeConge) {

        DemandeCongeDto demandeCongeDto = new DemandeCongeDto();
        demandeCongeDto.setId(demandeConge.getId());
        demandeCongeDto.setEmploye(demandeConge.getEmploye());
        demandeCongeDto.setDateDebut(demandeConge.getDateDebut());
        demandeCongeDto.setDateFin(demandeConge.getDateFin());
        demandeCongeDto.setDateDemande(demandeConge.getDateDemande());
        demandeCongeDto.setStatutConge(demandeConge.getStatutConge());
        demandeCongeDto.setTypeConge(demandeConge.getTypeConge());
        return demandeCongeDto;
    }

    public DemandeConge toBean(DemandeCongeDto demandeCongeDto) {

        DemandeConge demandeConge = new DemandeConge();
        demandeConge.setId(demandeCongeDto.getId());
        demandeConge.setEmploye(demandeCongeDto.getEmploye());
        demandeConge.setDateDebut(demandeCongeDto.getDateDebut());
        demandeConge.setDateFin(demandeCongeDto.getDateFin());
        demandeConge.setDateDemande(demandeCongeDto.getDateDemande());
        demandeConge.setStatutConge(demandeCongeDto.getStatutConge());
        demandeConge.setTypeConge(demandeCongeDto.getTypeConge());
        return demandeConge;
    }

    public List<DemandeConge> toBean(List<DemandeCongeDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }


    public List<DemandeCongeDto> toDto(List<DemandeConge> commandes) {
        return commandes.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

}
