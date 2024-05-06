package sir.zproject.pfe_back.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum SITUATION_FAMILIALE {
    CELIBATAIRE("Célibataire"),
    MARIE("Marié");

    private final String label;

    SITUATION_FAMILIALE (String label) {
        this.label = label;
    }


}
