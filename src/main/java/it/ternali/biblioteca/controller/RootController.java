package it.ternali.biblioteca.controller;

import it.ternali.biblioteca.model.entity.Ruolo;
import it.ternali.biblioteca.model.entity.Utente;
import it.ternali.biblioteca.model.entity.security.LoginValidator;
import it.ternali.biblioteca.model.entity.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RootController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping("/")
    public String getRegPage(Model model) {
        model.addAttribute("utente", new Utente());
        return "registration-page";
    }

    @GetMapping("/login")
    public String getLogPage(Model model) {
        model.addAttribute("loginValidator", new LoginValidator());
        return "login-page";
    }

    @PostMapping("/checkRegistration")
    public String validAndRedirect(@Valid @ModelAttribute("utente") Utente validationUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("Errore durante la registrazione dell'utente.");
            System.out.println(result.getAllErrors());
            model.addAttribute("register_error", true);
            return "registration-page";
        } else {
            validationUser.setRuolo(Ruolo.USER.toString());
            utenteService.save(validationUser);
            model.addAttribute("loginValidator", new LoginValidator());
            return "home-page";
        }
    }

    @PostMapping("/checklogin")
    public String checkLogin(@Valid @ModelAttribute("loginValidator") LoginValidator validator, Model model) {
        if (utenteService.findByUsernameAndPassword(validator.getEmail(), validator.getPassword())) {
            return "home-page";
        } else {
            System.out.println("Errore durante il login.");
            model.addAttribute("login_error", true);
            return "login-page";
        }
    }

}
