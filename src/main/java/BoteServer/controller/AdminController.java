package BoteServer.controller;

import BoteServer.configuration.WebSocketEventListener;
import BoteServer.service.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Den 20.06.2024
 */

@Controller
public class AdminController {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private WebSocketEventListener eventListener;

    @GetMapping(value = "/admin")
    public String admin(Model model){

        model.addAttribute("zeitstempel", runtimeService.getRuntimeSinceStart());
        model.addAttribute("online", "Online: " + eventListener.getClientCount());

        return "/admin";
    }
}
