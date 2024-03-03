package BoteServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Den 3.3.24
 */

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){

        return "home";
    }
}
