package com.chatapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.model.Post;
import com.chatapp.service.PostService;


@RestController
@RequestMapping("/{memberId}/chat/{chatId}/post/")
public class PostController {
 
    private final PostService postService;

    PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/new")
    public Post newPost(
        @PathVariable Long memberId, 
        @PathVariable Long chatId,
        @RequestBody String content    
    ){
       return postService.newPost(chatId, memberId, content);
    }

    @DeleteMapping("/delete/{postId}")
    public void deletePost(@PathVariable Long memberId, @PathVariable Long chatId, @PathVariable Long postId){
        postService.deletePost(memberId,chatId,postId);
    }

    @PutMapping("/edit/{postId}")
    public void editPost(
        @PathVariable Long memberId,
        @PathVariable Long postId,
        @RequestBody String content
    ){
        postService.editPost(memberId, postId, content);
    }


    
}
