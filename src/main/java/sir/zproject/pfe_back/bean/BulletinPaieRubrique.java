package sir.zproject.pfe_back.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class BulletinPaieRubrique {
    @EmbeddedId
    private BulletinPaieRubriqueKey id;

    @ManyToOne
    @MapsId("bulletinPaieId")
    @JoinColumn(name = "bulletinPaie_id")
    BulletinPaie bulletinPaie;

    @ManyToOne
    @MapsId("rubriqueId")
    @JoinColumn(name = "rubrique_id")
    Rubrique rubrique;

    private BigDecimal montant;
    private BigDecimal nombre;
}
