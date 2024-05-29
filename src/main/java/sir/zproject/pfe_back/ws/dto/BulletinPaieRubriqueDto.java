package sir.zproject.pfe_back.ws.dto;

import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.BulletinPaie;
import sir.zproject.pfe_back.bean.Rubrique;

import java.math.BigDecimal;
@Getter
@Setter
public class BulletinPaieRubriqueDto {
    private Long bulletinPaieId;
    private Long rubriqueId;
    private BigDecimal montant;
    private RubriqueDto rubrique;
    private BigDecimal nombre;
}
