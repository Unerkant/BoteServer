package BoteServer.controller;

import BoteServer.service.RuntimeService;
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
    private RuntimeService runtimeService;


    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {

        // Server laufzeit in footer anzeigen
        model.addAttribute("zeitstempel", runtimeService.getRuntimeSinceStart());

        return "home";
    }


}
