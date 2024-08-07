package BoteServer.controller;

import BoteServer.configuration.WebSocketEventListener;
import BoteServer.service.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Den 3.3.24
 */

@Controller
public class HomeController {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private WebSocketEventListener eventListener;


    @GetMapping(value = {"/", "/home", "/home/{path}"})
    public String home(Model model, @RequestParam(required = false) String path) {

        // Server laufzeit in footer(fragment) anzeigen
        model.addAttribute("zeitstempel", runtimeService.getRuntimeSinceStart());
        // path an home senden
        model.addAttribute("path", path);

        return "/home";
    }

}
