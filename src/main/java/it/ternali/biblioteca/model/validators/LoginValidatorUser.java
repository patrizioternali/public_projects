package it.ternali.biblioteca.model.validators;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginValidatorUser {

    @NotEmpty(message = "L'email non può essere vuota.")
    @Email(message = "Inserire un'email valida.")
    private String email;
    @NotEmpty(message = "La password non può essere vuota")
    private String password;

}
