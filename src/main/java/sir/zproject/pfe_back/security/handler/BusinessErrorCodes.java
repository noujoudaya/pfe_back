package sir.zproject.pfe_back.security.handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum BusinessErrorCodes {

    NO_CODE(0,NOT_IMPLEMENTED,"Aucun code n'a été trouvé."),
    INCORRECT_CURRENT_PASSWORD(300,BAD_REQUEST,"Le mot de passe actuel est incorrect."),

    NEW_PASSWORD(301,BAD_REQUEST, "Le nouveau mot de passe ne correspond pas."),
    ACCOUNT_LOCKED(302,FORBIDDEN,"Ce compte est bloqué"),
    ACCOUNT_DISABLED(303,FORBIDDEN,"Ce compte est désactivé"),
    BAD_CREDENTIALS(304,FORBIDDEN,"Email et/ou mot de passe est incorrect"),
    ;
    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatus;

    BusinessErrorCodes(int code,HttpStatus httpStatus, String description) {
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
