package co.edu.eci.LaReserva.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SocketController {
    
    private Map<String, Message> usuariosActivos = new HashMap<>();

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/{cancha}")
    public void usuariosReservando(String message) throws Exception {
        if(usuariosActivos.containsKey(message)) {
            usuariosActivos.get(message).incrementByOne();
            this.messageTemplate.convertAndSend("/topic/" + message, usuariosActivos.get(message));
        } else {
            if(message.contains("#")) {
                usuariosActivos.get(message.split("#")[1]).decreaseByOne();
                this.messageTemplate.convertAndSend("/topic/" + message.split("#")[1], usuariosActivos.get(message.split("#")[1]));
            }else {
                usuariosActivos.put(message, new Message(1));
                this.messageTemplate.convertAndSend("/topic/" + message, usuariosActivos.get(message));
            }
        }
    }

    public class Message {

        private Integer content;

        public Message() {
        }

        public Message(Integer content) {
            this.content = content;
        }

        public Integer getContent() {
            return content;
        }
        
        public void incrementByOne() {
            this.content = this.content + 1;
        }
        
        public void decreaseByOne() {
            this.content = this.content - 1;
        }
    }
}
