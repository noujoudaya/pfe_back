package sir.zproject.pfe_back.security.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Employe;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private String token;
    private Employe employe;
}
