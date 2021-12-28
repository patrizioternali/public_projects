package it.ternali.biblioteca.model.entity.repository;

import it.ternali.biblioteca.model.entity.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {
    Utente findByEmail(String email);
    Utente findByEmailAndPassword(String email, String password);
}
