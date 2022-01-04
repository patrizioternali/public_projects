package it.ternali.biblioteca.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ternali.biblioteca.model.Libro;
import it.ternali.biblioteca.model.PopularBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/homepage")
    public ModelAndView getHomePage(HttpServletRequest request, Model model) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return new ModelAndView("redirect:/");
        } else {
            ObjectMapper jsonReader = new ObjectMapper();
            JsonNode libri = jsonReader.readTree(new URL("https://api.itbook.store/1.0/new")).get("books");
            List<PopularBook> popularBooks = new ArrayList<>();
            if (libri.isArray()) {
                int count = 0;
                for (JsonNode node : libri) {
                    if (count == 5)
                        break;
                    PopularBook libro = new PopularBook();
                    libro.setTitle(node.get("title").toString());
                    libro.setSubtitle(node.get("subtitle").toString());
                    libro.setImage(node.get("image").toString());
                    libro.setUrl(node.get("url").toString());
                    popularBooks.add(libro);
                    count++;
                }
            }
            ModelAndView mv = new ModelAndView("home-page");
            mv.addObject("popularBooks", popularBooks);
            return mv;
        }
    }
}
