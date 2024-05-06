package sir.zproject.pfe_back.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SITUATION_FAMILIALE {
    CELIBATAIRE("Célibataire"),
    MARIE("Marié");

    private final String label;

    SITUATION_FAMILIALE (String label) {
        this.label = label;
    }

    // Getter for label
    @JsonValue
    public String getLabel() {
        return label;
    }
}
