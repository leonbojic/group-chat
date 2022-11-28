package com.chatapp.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chatapp.exception.ChatNotFoundException;
import com.chatapp.exception.MemberNotFoundException;
import com.chatapp.exception.MemberNotInChatException;
import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.MemberRepository;
import com.chatapp.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepository;
    private final MemberRepository memberRepository;
   // private final PostRepository postRepository;

    public ChatServiceImpl(
            ChatRepository chatRepository,
            MemberRepository memberRepository
        //    PostRepository postRepository
    ) {
        this.chatRepository = chatRepository;
        this.memberRepository = memberRepository;
  //      this.postRepository = postRepository;
    }

    @Override
    public Chat addMember(Long chatId, Long memberId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        if(chat.getMembers().contains(member)){
            return chat;
        }
        chat.addMember(member);
        member.addChat(chat);
        memberRepository.save(member);
        return chatRepository.save(chat);
    }
    @Override
    public Chat newChat(List<Long> memberIds) {
        Chat newChat = new Chat();
        String chatName = "";
        for(Long memberId : memberIds){
            Member chatMember = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
            chatMember.addChat(newChat);
            newChat.addMember(chatMember);
            chatName += chatMember.getUsername() + ", ";
           // memberRepository.save(chatMember);
        }
        newChat.setChatname(chatName);
        return chatRepository.save(newChat);
    }
    @Override
    public Chat removeMember(Long chatId, Long memberId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(()-> new ChatNotFoundException(chatId));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        if(!chat.getMembers().contains(member)){
            throw new MemberNotInChatException(memberId);
        }
        member.removeChat(chat);
        chat.removeMember(member);
        memberRepository.save(member);

        if(chat.getMembers().isEmpty()){
            chatRepository.delete(chat);
            return null;
        }
        return chatRepository.save(chat);
    }
    @Override
    public Chat getChat(Long id) {
        return chatRepository.findById(id).orElseThrow(() -> new ChatNotFoundException(id));
    }

    @Override
    public Set<Member> getMembers(Long chatId){
        return chatRepository.findById(chatId).orElseThrow(()-> new ChatNotFoundException(chatId)).getMembers(); 
    }
}
