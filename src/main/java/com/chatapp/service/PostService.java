package com.chatapp.service;

import com.chatapp.model.Post;

public interface PostService {
    Post newPost(Long chatId, Long memberId, String content);
    void deletePost(Long memberId, Long chatId, Long postId);
    Post editPost(Long memberId, Long postId, String content);
}
