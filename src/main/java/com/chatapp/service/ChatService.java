package com.chatapp.service;

import java.util.List;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;

public interface ChatService {
    //Chat newChat(); Empty Chat
    Chat newChat(List<Long> memberIds); 
    void deleteChat(Chat chat);
    //void deleteChat(Long id); Delete Chat by Id
    Chat addMember(Chat chat, Member member);
    Chat removeMemver(Chat chat, Member member);
}
