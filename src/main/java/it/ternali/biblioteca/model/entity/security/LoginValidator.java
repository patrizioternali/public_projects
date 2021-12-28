package it.ternali.biblioteca.model.entity.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class LoginValidator {
    @NotEmpty(message = "La password non puo essere vuota")
    private String password;
    @NotEmpty(message = "L'email non puo essere vuota")
    @Email(message = "Inserisci un'email valida.")
    private String email;
}
