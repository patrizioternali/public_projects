package it.ternali.biblioteca.controller;

import it.ternali.biblioteca.controller.service.UtenteService;
import it.ternali.biblioteca.model.Ruolo;
import it.ternali.biblioteca.model.validators.RegistrationValidatorUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private UtenteService service;

    @GetMapping("/registercheck")
    public String redirectRegister(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("logged") != null) {
                System.out.println("Utente già loggato, reindirizzamento alla home-page");
                return "redirect:/homepage";
            } else {
                System.out.println("Utente non registrato con sessione, rendirizzamento alla register-page");
                model.addAttribute("utente_register", new RegistrationValidatorUser());
                return "registration-page";
            }
        } else {
            System.out.println("Utente senza sessione reindirizzamento alla root-page");
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("utente_register") RegistrationValidatorUser validatorUser,
                                 BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("reg_error", true);
            System.out.println("Errore durante la registrazione");
            return "redirect://";
        }
        validatorUser.setRuolo(Ruolo.USER.toString());
        if (service.save(validatorUser)) {
            session.setAttribute("logged", true);
            return "redirect:/homepage";
        }
        return "redirect://";
    }

}
