/*
package it.ternali.biblioteca.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.ternali.biblioteca.model.Libro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("/books")
public class BookRESTController {

    @GetMapping("/popular")
    public String getPopularBooks(HttpServletRequest request,
                                  HttpServletResponse response,
                                  RedirectAttributes redirectAttributes) throws IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("admin") != null) {
                ObjectMapper jsonReader = new ObjectMapper();
                Libro[] libri = jsonReader.readValue(new URL("https://api.itbook.store/1.0/new"), Libro[].class);
                redirectAttributes.addFlashAttribute("popular_books", libri);
            } else {
                response.setStatus(403);
            }
        } else {
            response.setStatus(404);
        }

        // COMPLETARE METODO REST API
    }

}
*/
