package sir.zproject.pfe_back.ws.dto;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Departement;

@Getter
@Setter
public class ServiceDto {
    private Long id;
    private String libelle;
    private String code;
    private Departement departement;
}
