package sir.zproject.pfe_back.enumeration;


public enum TYPE_SALAIRE {
    MENSUEL("Mensuel"),
    PAR_HEURE("Par heure");

    private final String label;

    TYPE_SALAIRE(String label) {
        this.label = label;
    }

    // Getter for label
    public String getLabel() {
        return label;
    }
}
