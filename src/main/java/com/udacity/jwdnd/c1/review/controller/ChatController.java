package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChat(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        model.addAttribute("greetings", this.messageService.getMessage());
        return "chat";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatHistory());
        return "chat";
    }

    @ModelAttribute("allTypes")
    public String[] allTypes () {
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
