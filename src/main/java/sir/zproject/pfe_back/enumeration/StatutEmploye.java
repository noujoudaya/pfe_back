package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum StatutEmploye {
    PERMANENT("Permanent"),
    OCCASIONNEL("Occasionnel"),
    VACATAIRE("Vacataire"),
    TAHFIZ("Tahfiz"),
    STAGIAIRE("Stagiaire");

    private final String label;

    StatutEmploye( String label) {
        this.label = label;
    }
}
