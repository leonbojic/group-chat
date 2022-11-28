package com.chatapp.controller;


import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.assembler.PostModelAssembler;
import com.chatapp.model.Post;
import com.chatapp.service.PostService;


@RestController
@RequestMapping("/{memberId}/chat/{chatId}/post/")
public class PostController {
    private final PostModelAssembler postAssembler;
    private final PostService postService;

    PostController(PostService postService, PostModelAssembler postAssembler){
        this.postService = postService;
        this.postAssembler = postAssembler;
    }

    @PostMapping("/new")
    public ResponseEntity<Post> newPost(
        @PathVariable Long memberId, 
        @PathVariable Long chatId,
        @RequestBody String content    
    ){
       return ResponseEntity.ok(postService.newPost(chatId, memberId, content));
    }

    @DeleteMapping("/{postId}/delete")
    public ResponseEntity<?> deletePost(@PathVariable Long memberId, @PathVariable Long chatId, @PathVariable Long postId){
        postService.deletePost(memberId,chatId,postId);
        return ResponseEntity.of(null);
    }

    @PutMapping("/{postId}/edit")
    public ResponseEntity<?> editPost(
        @PathVariable Long memberId,
        @PathVariable Long postId,
        @RequestBody String content
    ){
        Post post = postService.editPost(memberId, postId, content);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{postId}")
    public EntityModel<Post> one(@PathVariable Long memberId,@PathVariable Long postId){
        Post post = postService.getOne(memberId, postId);
        
        return postAssembler.toModel(post);
    }

    
}
