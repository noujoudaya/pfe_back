package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum TypeAttestation {
    Travail("Travail"),
    Salaire("Salaire");

    private final String label;
    TypeAttestation(String label) {
        this.label = label;
    }
}
