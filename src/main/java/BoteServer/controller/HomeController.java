package BoteServer.controller;

import BoteServer.configuration.WebSocketEventListener;
import BoteServer.model.Message;
import BoteServer.service.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Den 3.3.24
 */

@Controller
public class HomeController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private WebSocketEventListener eventListener;


    @GetMapping(value = {"/", "/home"})
    public String home(Model model) {

        // Server laufzeit in footer(fragment) anzeigen
        model.addAttribute("zeitstempel", runtimeService.getRuntimeSinceStart());
        model.addAttribute("online", "Online: " + eventListener.getClientCount());

        return "home";
    }



    @MessageMapping("/messages")
    public void messageReceiving(Message message) {

        simpMessagingTemplate.convertAndSend("/messages/receive/" + message.getRecipient(), message);

    }
}
