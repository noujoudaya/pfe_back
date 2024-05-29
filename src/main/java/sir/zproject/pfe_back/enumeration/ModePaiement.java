package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum ModePaiement {
    ESPECE("ESPECE"),
    VIREMENT("VIREMENT"),
    CHEQUE("CHEQUE");

    private final String label;

    ModePaiement(String label) {
        this.label = label;
    }
}
