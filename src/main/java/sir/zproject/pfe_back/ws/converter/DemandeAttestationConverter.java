package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.ws.dto.AbsenceDto;
import sir.zproject.pfe_back.ws.dto.DemandeAttestationDto;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DemandeAttestationConverter {

    public DemandeAttestationDto toDto(DemandeAttestation demandeAttestation) {
        DemandeAttestationDto demandeAttestationDto = new DemandeAttestationDto();
        demandeAttestationDto.setId(demandeAttestation.getId());
        demandeAttestationDto.setEmploye(demandeAttestation.getEmploye());
        demandeAttestationDto.setDateDemande(demandeAttestation.getDateDemande());
        demandeAttestationDto.setTypeAttestation(demandeAttestation.getTypeAttestation());
        demandeAttestationDto.setStatutAttestation(demandeAttestation.getStatutAttestation());
        return demandeAttestationDto;
    }

    public DemandeAttestation toBean(DemandeAttestationDto demandeAttestationDto) {

        DemandeAttestation demandeAttestation = new DemandeAttestation();
        demandeAttestation.setId(demandeAttestationDto.getId());
        demandeAttestation.setEmploye(demandeAttestationDto.getEmploye());
        demandeAttestation.setDateDemande(demandeAttestationDto.getDateDemande());
        demandeAttestation.setTypeAttestation(demandeAttestationDto.getTypeAttestation());
        demandeAttestation.setStatutAttestation(demandeAttestationDto.getStatutAttestation());
        return demandeAttestation;
    }

    public List<DemandeAttestation> toBean(List<DemandeAttestationDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }


    public List<DemandeAttestationDto> toDto(List<DemandeAttestation> commandes) {
        return commandes.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

}
