package sir.zproject.pfe_back.enumeration;

public enum DESIGNATION {
    MANAGER("Manager"),
    INGENIEUR("Ingénieur"),
    ANALYSTE("Analyste"),
    ADMINISTRATEUR("Administrateur"),
    SPECIALISTE("Spécialiste"),
    ASSISTANT("Assistant"),
    DIRECTEUR("Directeur"),
    SUPERVISEUR("Superviseur"),
    CONSULTANT("Consultant"),
    COORDONNATEUR("Coordinateur"),
    TECHNICIEN("Technicien"),
    STAGIAIRE("Stagiaire"),
    CADRE("Cadre"),
    AGENT("Agent"),
    CHEF_EQUIPE("Chef d'équipe"),
    RESPONSABLE_RH("Responsable RH");


    private final String designation;

    DESIGNATION(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
