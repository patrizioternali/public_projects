package it.ternali.biblioteca.model.validators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class LoginValidatorUser {

    @NotEmpty(message = "L'email non può essere vuota.")
    private String username;
    @NotEmpty(message = "La password non può essere vuota")
    private String password;

}
