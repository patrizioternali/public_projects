package it.ternali.biblioteca.model.repository;

import it.ternali.biblioteca.model.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {
    Utente findByEmail(String email);
}
