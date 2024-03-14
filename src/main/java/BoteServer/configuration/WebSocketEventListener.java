package BoteServer.configuration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Den 14.03.2024
 */

@Component
public class WebSocketEventListener {

    public Integer clientCount = 0;

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {

        clientPlus(clientCount);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {

        clientMinus(clientCount);
    }


    private void clientPlus(Integer plus) {

        clientCount = plus + 1;

    }

    private void clientMinus(Integer minus) {

        clientCount = minus - 1;

    }


}
