package BoteServer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Den 7.3.2024
 */

@Controller
public class MessageController {


    @GetMapping(value = "/message")
    public String index(){

        return "/message";
    }


}
