package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RubriqueDto {
    private Long id;
    private Long code;
    private String libelle;
    private Boolean imposable;


}
