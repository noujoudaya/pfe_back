package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum TypeContrat {
    CDD("CDD"),
    CDI("CDI");

    private final String label;

    TypeContrat(String label) {
        this.label = label;
    }
}

