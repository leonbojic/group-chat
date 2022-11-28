package com.chatapp.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.chatapp.controller.ChatController;
import com.chatapp.model.Chat;

@Component
public class ChatModelAssembler implements RepresentationModelAssembler<Chat, EntityModel<Chat>> {
    
    @Override
    public EntityModel<Chat> toModel(Chat chat){
        return EntityModel.of(chat,
                linkTo(methodOn(ChatController.class).getChat(chat.getId())).withSelfRel()
               // linkTo(methodOn(ChatController.class).getMembers(chat.getId())).withRel("members")
                //linkTo(methodOn(ChatController.class).addMember(chat.getId(),null).withRel("add"),
                //linkTo(methodOn(ChatController.class).addMember(chat.getId(), null)).withRel("delete")
        );
    }

}
