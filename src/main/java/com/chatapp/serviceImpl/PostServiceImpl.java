package com.chatapp.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
import com.chatapp.model.Post;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.MemberRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    private final ChatRepository chatRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public PostServiceImpl(
            ChatRepository chatRepository,
            MemberRepository memberRepository,
            PostRepository postRepository
    ) {
        this.chatRepository = chatRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void deletePost(Long memberId, Long chatId, Long postId) {
        Post post = postRepository.findById(postId).get();

        if(!post.getPoster().equals(memberRepository.findById(memberId).get())){
            return;
        }        
        Chat chat = chatRepository.findById(chatId).get();
        chat.removePost(post);
        
        chatRepository.save(chat);
    }

    @Override
    public Post newPost(Long chatId, Long memberId, String content) {
        Member member = memberRepository.findById(memberId).get();
        Chat chat = chatRepository.findById(chatId).get();
        
        Post post = new Post(member, content);

        if(!chat.getMembers().contains(member)){
            return post;
        }
        post.setCreatedAt(LocalDateTime.now());

        chat.addPost(post);
        chatRepository.save(chat);
        return post;
    }

    @Override
    public Post editPost(Long memberId, Long postId, String content){
        Post post = postRepository.findById(postId).get();
        if(!post.getPoster().equals(memberRepository.findById(memberId).get())){
            return post;
        }
        post.setEditedAt(LocalDateTime.now());

        post.setContent(content);
        return postRepository.save(post);
    }
}
