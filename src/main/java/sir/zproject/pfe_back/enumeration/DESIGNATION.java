package sir.zproject.pfe_back.enumeration;

import lombok.Getter;

@Getter
public enum DESIGNATION {
    MANAGER("MANAGER"),
    INGENIEUR("INGENIEUR"),
    ANALYSTE("ANALYSTE"),
    ADMINISTRATEUR("ADMINISTRATEUR"),
    SPECIALISTE("SPECIALISTE"),
    ASSISTANT("ASSISTANT"),
    DIRECTEUR("DIRECTEUR"),
    SUPERVISEUR("SUPERVISEUR"),
    CONSULTANT("CONSULTANT"),
    COORDONNATEUR("COORDONNATEUR"),
    TECHNICIEN("TECHNICIEN"),
    STAGIAIRE("STAGIAIRE"),
    CADRE("CADRE"),
    AGENT("AGENT"),
    CHEF_EQUIPE("CHEF_EQUIPE"),
    RESPONSABLE_RH("RESPONSABLE_RH");


    private final String label ;

    DESIGNATION(String label) {
        this.label = label;
    }

}

