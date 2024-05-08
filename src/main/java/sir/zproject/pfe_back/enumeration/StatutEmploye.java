package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum StatutEmploye {
    PERMANENT("PERMANENT"),
    OCCASIONNEL("OCCASIONNEL"),
    VACATAIRE("VACATAIRE"),
    TAHFIZ("TAHFIZ"),
    STAGIAIRE("STAGIAIRE");

    private final String label;

    StatutEmploye( String label) {
        this.label = label;
    }
}
