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
public class UpdateValidatorUser {

    @NotEmpty(message = "L'username dev'essere specificato.")
    private String username;
    @NotEmpty(message = "L'email dev'essere specificata.")
    @Email(message = "Inserire un'email valida.")
    private String email;
    @NotNull(message = "La data di nascita non può essere vuota.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDiNascita;
}
