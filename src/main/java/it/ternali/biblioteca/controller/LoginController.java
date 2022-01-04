package it.ternali.biblioteca.controller;

import it.ternali.biblioteca.controller.service.UtenteService;
import it.ternali.biblioteca.model.Utente;
import it.ternali.biblioteca.model.validators.LoginValidatorUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class LoginController {

    private UtenteService service;

    @GetMapping("/logincheck")
    public String getLoginPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("logged") != null) {
                System.out.println("Utente già loggato, reindirizzamento alla home-page");
                return "redirect:/homepage";
            } else {
                System.out.println("Utente con sessione ma non loggato, reindirizzamento alla registration-page");
                model.addAttribute("log_validator", new LoginValidatorUser());
                return "login-page";
            }
        } else {
            System.out.println("Utente senza sessione reindirizzamento alla root-page");
            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public String login(@Valid @ModelAttribute("log_validator") LoginValidatorUser validatorUser,
                              BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            System.out.println("Errore durante il login");
            model.addAttribute("log_error", true);
            return "redirect:/logincheck";
        }
        Utente utente = service.checkLogin(validatorUser);
        if (utente != null) {
            model.addAttribute("logged", true);
            session.setAttribute("logged", true);
            if (utente.getRuolo().equals("ADMIN")) {
                session.setAttribute("admin", true);
            }
            return "redirect:/homepage";
        } else {
            return "redirect:/logincheck";
        }
    }
}
