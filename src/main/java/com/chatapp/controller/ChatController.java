package com.chatapp.controller;

import java.util.List;
import java.util.Set;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.assembler.ChatModelAssembler;
import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatModelAssembler chatAssembler;
    private final ChatService chatService;

    public ChatController(ChatModelAssembler chatAssembler, ChatService chatService) {
        this.chatAssembler = chatAssembler;
        this.chatService = chatService;
    }

    @PostMapping("/new")
    public Chat newChat(@RequestBody List<Long> memberIds){
        return chatService.newChat(memberIds);
    }
    @PutMapping("/{chatId}/add/{memberId}")
    public Chat addMember(@PathVariable Long chatId, @PathVariable Long memberId){
        return chatService.addMember(chatId, memberId);
    }
    @PutMapping("/{chatId}/remove/{memberId}")
    public Chat removeMember(@PathVariable Long chatId, @PathVariable Long memberId){
        return chatService.removeMember(chatId, memberId);
    }
    @GetMapping("/{chatId}")
    public EntityModel<Chat> getChat(@PathVariable Long chatId){
        return chatAssembler.toModel(chatService.getChat(chatId));
    }
    @GetMapping("/members")
    public Set<Member> getMembers(@PathVariable Long chatId){
        return chatService.getMembers(chatId);
    }

}
