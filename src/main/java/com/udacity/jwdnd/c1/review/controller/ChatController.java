package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getChat(ChatForm chatForm, Model model){
        model.addAttribute("greetings", this.messageService.getChatHistory());
        return "chat";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("chatForm") Authentication authentication, ChatForm chatForm, Model model){
        chatForm.setUsername(authentication.getName());
        this.messageService.addMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getChatHistory());
        return "chat";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, auth);
        }
        return "redirect:/";
    }

    @ModelAttribute("allTypes")
    public String[] allTypes () {
        return new String[]{"Say", "Shout", "Whisper"};
    }
}
