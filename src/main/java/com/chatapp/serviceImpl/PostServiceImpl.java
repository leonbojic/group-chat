package com.chatapp.serviceImpl;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chatapp.exception.ChatNotFoundException;
import com.chatapp.exception.MemberIsNotPosterException;
import com.chatapp.exception.MemberNotFoundException;
import com.chatapp.exception.MemberNotInChatException;
import com.chatapp.exception.PostNotFoundException;
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
        Member member = memberRepository.findById(memberId).orElseThrow(()->new MemberNotFoundException(memberId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));

        if(!post.getPoster().equals(member)){
            throw new MemberIsNotPosterException(memberId);
        }        
        Chat chat = chatRepository.findById(chatId).get();
        chat.removePost(post);
        
        chatRepository.save(chat);
    }

    @Override
    public Post newPost(Long chatId, Long memberId, String content) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
        
        Post post = new Post(member, content);

        

        if(!chat.getMembers().contains(member)){
            throw new MemberNotInChatException(memberId);
        }
        post.setCreatedAt(LocalDateTime.now());

        chat.addPost(post);
        chatRepository.save(chat);
        return post;
    }

    @Override
    public Post editPost(Long memberId, Long postId, String content){
        Member member =memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        
        if(!post.getPoster().equals(member)){
            throw new MemberIsNotPosterException(memberId);
        }
        post.setEditedAt(LocalDateTime.now());

        post.setContent(content);
        return postRepository.save(post);
    }

    @Override
    public Post getOne(Long memberId, Long postId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Post post= postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));
        
        if(!post.getPoster().equals(member)){
            throw new MemberIsNotPosterException(memberId);
        }

        return post;

    }

    @Override
    public Set<Post> getAll(Long memberId, Long chatId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new ChatNotFoundException(chatId));
        
        if(!chat.getMembers().contains(member)){
            throw new MemberNotInChatException(memberId);
        }

        return chat.getPosts();
    }

    @Override
    public Member getPoster(Long memberId, Long postId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId));

        if(!post.getPoster().equals(member)){
            throw new MemberIsNotPosterException(memberId);
        }

        return post.getPoster();
    }


}
