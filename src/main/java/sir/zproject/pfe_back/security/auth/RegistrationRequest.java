package sir.zproject.pfe_back.security.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.security.role.Role;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotEmpty(message = "Le prénom ne peut pas être vide.")
    @NotBlank(message = "Le prénom ne peut pas être vide.")
    private String firstname;
    @NotEmpty(message = "Le nom ne peut pas être vide.")
    @NotBlank(message = "Le nom ne peut pas être vide.")
    private String lastname;
    @NotEmpty(message = "L'adresse login ne peut pas être vide.")
    @NotBlank(message = "L'adresse login ne peut pas être vide.")
    @Email(message = "Email invalide.")
    private String email;
    @NotEmpty(message = "Le mot de passe ne peut pas être vide.")
    @NotBlank(message = "Le mot de passe ne peut pas être vide.")
    @Size(min = 8,message = "Le mot de passe doit comporter au moins 8 caractères.")
    private String password;
    private Role role;

}
