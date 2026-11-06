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
    @JoinColumn(name = "bulletin_paie_id")  // Use consistent naming
    private BulletinPaie bulletinPaie;

    @ManyToOne
    @MapsId("rubriqueId")
    @JoinColumn(name = "rubrique_id")
    private Rubrique rubrique;

    private BigDecimal montant;
    private BigDecimal nombre;
}
