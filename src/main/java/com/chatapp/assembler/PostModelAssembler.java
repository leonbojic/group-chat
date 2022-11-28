package com.chatapp.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.chatapp.controller.ChatController;
import com.chatapp.controller.PostController;
import com.chatapp.model.Post;


@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {
    
    @Override
    public EntityModel<Post> toModel(Post post){
        return EntityModel.of(post,
            linkTo(methodOn(PostController.class).one(post.getPoster().getId(), post.getId())).withSelfRel(),
            linkTo(methodOn(ChatController.class).getChat(post.getChat().getId())).withRel("chat"),
            //member get

            linkTo(methodOn(PostController.class).editPost(post.getPoster().getId(), post.getId(), post.getContent())).withRel("edit"),
            linkTo(methodOn(PostController.class).deletePost(post.getPoster().getId(),post.getChat().getId(), post.getId())).withRel("delete")
    
        );

    }

}
