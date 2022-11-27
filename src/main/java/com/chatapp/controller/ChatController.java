package com.chatapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
    
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/foo/{id}")
    List<Chat> test(@PathVariable Long id){
        return chatService.findMemberById(id).getChats();

    }

    @PostMapping("/new")
    Chat newChat(@RequestBody List<Long> memberIds){
        return chatService.newChat(memberIds);
    }

    @PutMapping("/{chatId}/add/{memberId}")
    public Chat addMembertoChat(@PathVariable Long chatId, @PathVariable Long memberId){
        return chatService.addMember(chatId, memberId);
    }
    

    @GetMapping("/bar/{id}")
    Set<Member> bar(@PathVariable Long id){
        return chatService.findChatById(id).getMembers();
    }

    @GetMapping("/poo/{id}")
    Member poo(@PathVariable Long id){
        return chatService.findMemberById(id);
    }

    @DeleteMapping("/{chatId}/delete/{postId}")
    void deletePost(@PathVariable Long chatId, @PathVariable Long postId){
        chatService.deletePostFromChat(chatId, postId);

    }


}
