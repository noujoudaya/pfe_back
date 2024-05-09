package sir.zproject.pfe_back.enumeration;


import lombok.Getter;

@Getter
public enum TYPE_SALAIRE {
    MENSUEL("MENSUEL"),
    PAR_HEURE("PAR_HEURE");

    // Getter for label
    private final String label;

    TYPE_SALAIRE(String label) {
        this.label = label;
    }

}
