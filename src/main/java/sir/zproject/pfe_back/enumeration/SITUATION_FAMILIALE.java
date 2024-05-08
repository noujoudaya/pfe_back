package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum SITUATION_FAMILIALE {
    CELIBATAIRE("CELIBATAIRE"),
    MARIE("MARIE");

    private final String label;

    SITUATION_FAMILIALE (String label) {
        this.label = label;
    }


}
