package it.ternali.biblioteca.model.validators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AddValidatorUser {

    @NotEmpty(message = "L'username dev'essere specificato.")
    private String username;
    @NotEmpty(message = "L'email dev'essere specificata.")
    @Email(message = "Inserire un'email valida.")
    private String email;
    @NotEmpty(message = "La password dev'essere specificata.")
    private String password;
    @NotNull(message = "La data di nascita dev'essere specificata.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDiNascita;
    @NotEmpty(message = "Il ruolo dev'essere specificato.")
    private String ruolo;
}
