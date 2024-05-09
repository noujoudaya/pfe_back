package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum GENRE {
    HOMME("HOMME"),
    FEMME("FEMME");

    private final String label;

    GENRE(String label) {
        this.label = label;
    }
}
