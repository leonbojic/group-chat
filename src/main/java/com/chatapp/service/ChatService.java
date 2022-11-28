package com.chatapp.service;

import java.util.List;
import java.util.Set;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;

public interface ChatService {
    //Chat newChat(); Empty Chat
    Chat newChat(List<Long> memberIds); 
    Chat addMember(Long chatId, Long memberId);
    Chat removeMember(Long chatId, Long memberId);
    Chat getChat(Long id);
    Set<Member> getMembers(Long chatId);
}
