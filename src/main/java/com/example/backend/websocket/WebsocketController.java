package com.example.backend.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backend.dto.websocket.Message;
import com.example.backend.dto.websocket.OutputMessage;

@Controller
@CrossOrigin
public class WebsocketController {
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
    
    @RequestMapping("/api/basic/chat")
    public String chat() {
        return "chat";
    }


}
