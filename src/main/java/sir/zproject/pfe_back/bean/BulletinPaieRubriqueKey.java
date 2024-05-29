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
    @Column(name = "bulletinPaie_id")
    Long bulletinPaieId;
    @Column(name = "rubrique_id")
    Long rubriqueId;
}
