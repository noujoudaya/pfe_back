package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.BulletinPaie;

import java.util.List;

@Getter
@Setter
public class EntrepriseDto {
    private Long id;
    private String adresse;
    private Long numeroCNSS;
    private Long numeromutuelle;
    private String ice;
    private String identifiantFiscale;
    private String raisonSociale;

}
