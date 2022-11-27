package com.chatapp.service;

import java.util.List;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.model.Post;

public interface ChatService {
    //Chat newChat(); Empty Chat
    //Chat newChat(List<Long> memberIds); 
    Chat newChat(List<Long> memberIds); 
    void deleteChat(Chat chat);
    //void deleteChat(Long id); Delete Chat by Id
    //Chat addMember(Chat chat, Member member);
    Chat addMember(Long chatId, Long memberId);
    Chat removeMember(Chat chat, Member member);
    Post newPost(Post post); // This method is used by edit aswell
    void deletePost(Post post);

    Chat findChatById(Long id);
    Member findMemberById(Long id);
    Post findPostById(Long id);

}
