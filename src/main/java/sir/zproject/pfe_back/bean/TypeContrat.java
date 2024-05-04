package sir.zproject.pfe_back.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.enumeration.TYPE_SALAIRE;


@Entity
@Getter
@Setter
public class TypeContrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private TYPE_SALAIRE typeSalaire;
}