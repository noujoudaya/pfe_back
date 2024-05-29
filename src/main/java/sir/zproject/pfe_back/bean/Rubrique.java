package sir.zproject.pfe_back.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter

public class Rubrique  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long code;
    private String libelle;
    private Boolean imposable;
    @OneToMany(mappedBy = "rubrique",fetch = FetchType.EAGER )
    private   Set<BulletinPaieRubrique> bulletinPaieRubriques;


}
