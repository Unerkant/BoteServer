package BoteServer.controller;

import BoteServer.configuration.WebSocketEventListener;
import BoteServer.model.Message;
import BoteServer.service.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.thymeleaf.engine.ElementModelStructureHandler;
import org.xml.sax.Locator;

import javax.lang.model.element.Element;


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

        // Server laufzeit in footer anzeigen
        model.addAttribute("zeitstempel", runtimeService.getRuntimeSinceStart());
        model.addAttribute("online", "Online: " + eventListener.getClientCount());

        //System.out.println("Home Controller/@GetMapping: ");

        return "home";
    }


    /**
     * nimmt entgegen die message von BoteWebClient an und leitet an alle weiter
     *
     * @param message
     * @throws Exception
     */
    @MessageMapping("/messages")
    public void messageReceiving(Message message) throws Exception {
        simpMessagingTemplate.convertAndSend("/messages/receive/", message);

        //System.out.println("Home Controller/@MessageMapping, message weiter an alle gesendet: " + message);
    }
}
