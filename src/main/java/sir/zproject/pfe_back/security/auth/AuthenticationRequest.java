package sir.zproject.pfe_back.security.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @NotEmpty(message = "L'adresse e-mail ne peut pas être vide.")
    @NotBlank(message = "L'adresse e-mail ne peut pas être vide.")
    @Email(message = "Email invalide.")
    private String email;
    @NotEmpty(message = "Le mot de passe ne peut pas être vide.")
    @NotBlank(message = "Le mot de passe ne peut pas être vide.")
    @Size(min = 8,message = "Le mot de passe doit comporter au moins 8 caractères.")
    private String password;
}
