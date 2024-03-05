package BoteServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Den 3.3.24
 */

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    public String home(Model model){

        //model.addAttribute("homeversion", "0.0.1");
        return "home";
    }
}
