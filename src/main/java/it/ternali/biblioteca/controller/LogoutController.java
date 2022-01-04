package it.ternali.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String getLogout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("logged") != null) {
                session.removeAttribute("logged");
                session.removeAttribute("admin");
                session.invalidate();
                System.out.println("Logout effettuato.");
                return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
        return "redirect:/homepage";
    }

}
