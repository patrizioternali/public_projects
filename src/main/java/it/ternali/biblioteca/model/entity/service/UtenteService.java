package it.ternali.biblioteca.model.entity.service;

import it.ternali.biblioteca.controller.exception.UserAlreadyExistException;
import it.ternali.biblioteca.model.entity.Utente;
import it.ternali.biblioteca.model.entity.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository, BCryptPasswordEncoder passwordEncoder) {
        this.utenteRepository = utenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(Utente utente) {
        if (checkIfExist(utente.getEmail())) {
            throw new UserAlreadyExistException("Utente gia' registrato");
        } else {
            encrypt(utente);
            utenteRepository.save(utente);
            System.out.println("Utente salvato correttamente nel database");
        }
    }

    public boolean findByUsernameAndPassword(String email, String password) {
        Utente utente = utenteRepository.findByEmail(email);
        if (passwordEncoder.matches(password, utente.getPassword())) {
            System.out.println("Utente trovato correttamente.");
            return true;
        }
        System.out.println("Utente non trovato.");
        return false;
    }

    public boolean checkIfExist(String email) {
        if (utenteRepository.findByEmail(email) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void encrypt(Utente utente) {
        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
    }

}
