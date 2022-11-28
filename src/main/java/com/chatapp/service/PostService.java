package com.chatapp.service;

import java.util.Set;

import com.chatapp.model.Member;
import com.chatapp.model.Post;

public interface PostService {
    Post newPost(Long chatId, Long memberId, String content);
    void deletePost(Long memberId, Long chatId, Long postId);
    Post editPost(Long memberId, Long postId, String content);
    Post getOne(Long memberId, Long postId);
    Set<Post> getAll(Long memberId, Long chatId);
    Member getPoster(Long memberId, Long postId);
}
