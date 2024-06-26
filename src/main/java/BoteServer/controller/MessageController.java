package BoteServer.controller;

import BoteServer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/messages")
    public void messageReceiving(Message message) {
        simpMessagingTemplate.convertAndSend("/messages/receive/" + message.getRecipient(), message);
    }
}
