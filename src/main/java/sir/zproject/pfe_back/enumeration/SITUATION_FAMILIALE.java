package sir.zproject.pfe_back.enumeration;

public enum SITUATION_FAMILIALE {
    CELIBATAIRE("Célibataire"),
    MARIE(" Marié");

    private final String label;

    SITUATION_FAMILIALE (String label) {
        this.label = label;
    }

    // Getter for label
    public String getLabel() {
        return label;
    }
}
