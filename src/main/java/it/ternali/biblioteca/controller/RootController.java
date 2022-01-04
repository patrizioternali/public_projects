package it.ternali.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRootPage(HttpSession session, HttpServletRequest request) {
        if (session == null) {
            session = request.getSession(true);
            session.setAttribute("session", true);
            return "redirect:/homepage";
        }
        return "redirect:/homepage";
    }
}
