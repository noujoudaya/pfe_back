package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum StatutConge {
    En_Attente("En attente"),
    Acceptée("Acceptée"),
    Refusée("Refusée");

    private final String label;
    StatutConge(String label) {
        this.label = label;
    }
}
