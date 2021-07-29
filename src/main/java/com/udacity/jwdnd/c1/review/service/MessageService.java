package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private String message;
    private List<ChatMessage> chatHistory;

    public String messageToUpperCase(){
        return this.message.toUpperCase();
    }

    public String messageToLowerCase(){
        return this.message.toLowerCase();
    }

    public String getMessage(){ return this.message; }

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
        this.chatHistory.add(newMessage);
    }

    public List<ChatMessage> getChatHistory(){
        return chatHistory;
    }

    @PostConstruct
    public void postConstruct(){
        this.message = message;
        System.out.println("Creating MessageService Bean");
        this.chatHistory = new ArrayList<>();
    }
}
