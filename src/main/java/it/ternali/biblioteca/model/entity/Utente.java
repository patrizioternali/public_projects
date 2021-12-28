package it.ternali.biblioteca.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "L'username non puo essere vuoto")
    private String username;
    @NotEmpty(message = "La password non puo essere vuota")
    private String password;
    @Column(unique = true)
    @NotEmpty(message = "L'email non puo essere vuota")
    @Email(message = "Inserire un email valida")
    private String email;
    private String ruolo;
    @NotNull(message = "La data di nascita non puo essere vuota")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDiNascita;

    public Utente() {
    }

    public Utente(Long id, String username, String password, String email, String ruolo, LocalDate dataDiNascita) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.ruolo = ruolo;
        this.dataDiNascita = dataDiNascita;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
