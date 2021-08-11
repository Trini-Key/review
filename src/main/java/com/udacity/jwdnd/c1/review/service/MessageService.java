package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.MessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Creating MessageService Bean");
    }

    public void addMessage(ChatForm chatForm){
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()){
            case "Say":
                newMessage.setText(chatForm.getMessageText());
                break;
            case "Shout":
                newMessage.setText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                newMessage.setText(chatForm.getMessageText().toLowerCase());
                break;
        }
        messageMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getChatHistory(){
        return messageMapper.getAllMessages();
    }


}
