package BoteServer.controller;

import BoteServer.utilities.Methoden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Den 3.3.24
 */

@Controller
public class HomeController {

    @Autowired
    private Methoden methoden;


    /**
     * Home Anzeigen + Tomcat Serverzeit anzeige
     *
     * @param model
     * @return
     */
    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {

        // Tomcat Serverzeit anzeige in footer
        model.addAttribute("zeitstempel", methoden.zeitstempel());

        return "home";
    }


}
