package it.ternali.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/gestione")
public class GestioniController {

    private HttpSession session;

    @GetMapping("/utenti")
    public String gestioneUtenti(HttpServletRequest request,
                                 HttpServletResponse response) {
        session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("admin") != null) {
                return "gestione-utenti";
            } else {
                response.setStatus(403);
                return "403-forbidden";
            }
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/libri")
    public String gestioneLibri(HttpServletRequest request,
                                HttpServletResponse response) {
        session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("admin") != null) {
                return "gestione-utenti";
            } else {
                response.setStatus(403);
                return "403-forbidden";
            }
        } else {
            return "redirect:/";
        }
    }

}
