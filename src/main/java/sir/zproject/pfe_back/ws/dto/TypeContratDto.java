package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.TYPE_SALAIRE;

@Getter
@Setter
public class TypeContratDto {
    private Long id;
    private String libelle;
    private String code;
    private TYPE_SALAIRE typeSalaire;
}
