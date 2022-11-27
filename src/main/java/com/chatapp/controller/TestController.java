package com.chatapp.controller;

import java.util.List;

import org.h2.util.MemoryEstimator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.model.Post;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.repository.MemberRepository;
import org.springframework.web.bind.annotation.PutMapping;

@RequestMapping("/test")
@RestController
public class TestController {
    private final MemberRepository userRepository;
    private final ChatRepository chatRepository;
    private final PostRepository postRepository;

    
    public TestController(MemberRepository userRepository, ChatRepository chatRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/chat/{chatId}")
    List<Post> getConversation(@PathVariable Long chatId){
        return chatRepository.findById(chatId).get().getPosts();
    }

    @GetMapping("/chat/{chatId}/members")
    List<Member> getMembers(@PathVariable Long chatId){
        return chatRepository.findById(chatId).get().getMembers();
    }

    @PostMapping("/chat/new")
    Chat newChat(@RequestBody List<Long> memberIdList){
        Chat newChat = new Chat();
        String name = "";

        for(Long id : memberIdList){
            Member member = userRepository.findById(id).get();
            name = name + member.getUsername() + ' ';
            member.addChat(newChat);
            newChat.addMember(member);
        }
        newChat.setChatname(name);
        return chatRepository.save(newChat);
    }

    @PutMapping("/chat/{chatId}/addMember/{memberId}")
    public Chat addMemberToChat(@PathVariable Long memberId, @PathVariable Long chatId ) {
        Chat chat = chatRepository.findById(chatId).get();
        Member member = userRepository.findById(memberId).get();
        chat.addMember(member);
        member.addChat(chat);
        userRepository.save(member);
        return chatRepository.save(chat);
    }

    @GetMapping("/member/{memeberId}")
    public List<Chat> getMemeberChats(@PathVariable Long memeberId){
        return userRepository.findById(memeberId).get().getChats();
    }

}
