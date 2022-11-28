package com.chatapp.serviceImpl;


import org.springframework.stereotype.Service;

import com.chatapp.exception.ChatNotFoundException;
import com.chatapp.exception.MemberNotFoundException;
import com.chatapp.exception.PostNotFoundException;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.MemberRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.service.ExceptionService;


@Service
public class ExceptionServiceImpl implements ExceptionService {

    private final MemberRepository memberRepository;
    private final ChatRepository chatRepository;
    private final PostRepository postRepository;

    public ExceptionServiceImpl(
            MemberRepository memberRepository,
            ChatRepository chatRepository,
            PostRepository postRepository
    ) {
        this.memberRepository = memberRepository;
        this.chatRepository = chatRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void checkIfExists(Long memberId) {
        memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
    }

    @Override
    public void checkIfExists(Long memberId, Long chatId) {
        checkIfExists(memberId);
        chatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
    }

    @Override
    public void checkIfExists(Long memberId, Long chatId, Long postId) {
        checkIfExists(memberId, chatId);
        postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
    }

}
