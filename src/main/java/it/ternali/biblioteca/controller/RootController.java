package it.ternali.biblioteca.controller;

import it.ternali.biblioteca.security.data.UserData;
import it.ternali.biblioteca.security.exception.UserAlreadyExistException;
import it.ternali.biblioteca.security.service.CustomDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RootController {

    @Autowired
    private CustomDetailsService testCustomDetailsService;

    @GetMapping("/")
    public String getRegPage() {
        return "/registration-page";
    }

    @PostMapping("/register")
    public String registerForm(@Valid UserData userData, BindingResult result, Model model) {

        if (result.hasErrors())  {
            model.addAttribute("registrationError", true);
            return "/registration-page";
        }
        try {
            testCustomDetailsService.register(userData);
        } catch (UserAlreadyExistException e) {
            result.rejectValue("email", "Esiste gia un account con questa email");
            model.addAttribute("already_exist", true);
            return "/registration-page";
        }
        return "/login-page";

    }

}
