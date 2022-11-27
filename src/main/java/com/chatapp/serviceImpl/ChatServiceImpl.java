package com.chatapp.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.model.Post;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.repository.MemberRepository;
import com.chatapp.service.ChatService;
import com.fasterxml.classmate.MemberResolver;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public ChatServiceImpl(
            ChatRepository chatRepository,
            MemberRepository memberRepository,
            PostRepository postRepository
    ) {
        this.chatRepository = chatRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Override
    public Chat addMember(Long chatId, Long memberId) {
        Chat chat = this.findChatById(chatId);
        Member member = this.findMemberById(memberId);
        if(chat.getMembers().contains(member)){
            return chat;
        }
        chat.addMember(member);
        member.addChat(chat);
        memberRepository.save(member);
        String chatName = chat.getChatname();
        chatName += member.getUsername() + ", ";
        chat.setChatname(chatName);
        return chatRepository.save(chat);
    }

    @Override
    public void deleteChat(Chat chat) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletePost(Post post) {
        // TODO Auto-generated method stub

    }

    @Override
    public Chat newChat(List<Long> memberIds) {
        Chat newChat = new Chat();
        String chatName = "";

        for(Long memberId : memberIds){
            Member chatMember = memberRepository.findById(memberId).get();
            chatMember.addChat(newChat);
            newChat.addMember(chatMember);
            chatName += chatMember.getUsername() + ", ";
           // memberRepository.save(chatMember);
        }
        newChat.setChatname(chatName);
        return chatRepository.save(newChat);
    }

    @Override
    public Post newPost(Post post) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chat removeMember(Chat chat, Member member) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Chat findChatById(Long id) {
        return chatRepository.findById(id).get();
    }

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findById(id).get();
    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }


    
}
