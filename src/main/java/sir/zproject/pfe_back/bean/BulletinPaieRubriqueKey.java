package sir.zproject.pfe_back.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
public class BulletinPaieRubriqueKey implements Serializable {
    @Column(name = "bulletin_paie_id")
    private Long bulletinPaieId;

    @Column(name = "rubrique_id")
    private Long rubriqueId;
}
