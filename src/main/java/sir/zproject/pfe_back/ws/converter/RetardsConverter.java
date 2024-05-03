package sir.zproject.pfe_back.ws.converter;

import org.springframework.stereotype.Component;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.ws.dto.RetardDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetardsConverter {

  public RetardDto toDto(Retard retard) {

      RetardDto retardDto = new RetardDto();
      retardDto.setId(retard.getId());
      retardDto.setEmploye(retard.getEmploye());
      retardDto.setDateRetard(retard.getDateRetard());
      retardDto.setHeureArrivee(retard.getHeureArrivee());
      retardDto.setHeureDebutTravail(retard.getHeureDebutTravail());
      return retardDto;
  }

  public Retard toBean(RetardDto retardDto) {

      Retard retard = new Retard();
      retard.setId(retardDto.getId());
      retard.setEmploye(retardDto.getEmploye());
      retard.setDateRetard(retardDto.getDateRetard());
      retard.setHeureArrivee(retardDto.getHeureArrivee());
      retard.setHeureDebutTravail(retardDto.getHeureDebutTravail());
      return retard;
  }

    public List<Retard> toBean(List<RetardDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }


    public List<RetardDto> toDto(List<Retard> commandes) {
        return commandes.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }





}
