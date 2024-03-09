package BoteServer.controller;

import BoteServer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Den 7.3.2024
 */

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping(value = {"/", "/message"})
    public String index(){

        return "/message";
    }


    @MessageMapping("/messages")
    public void messageReceiving(Message message) throws Exception {

        simpMessagingTemplate.convertAndSend("/messages/receive/", message);

    }

}
