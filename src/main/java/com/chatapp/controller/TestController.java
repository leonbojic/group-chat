package com.chatapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.repository.UserRepository;

@RestController
public class TestController {
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final PostRepository postRepository;

    
    public TestController(UserRepository userRepository, ChatRepository chatRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.postRepository = postRepository;
    }

    

}
