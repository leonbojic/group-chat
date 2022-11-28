package com.chatapp.exception;

public class ChatNotFoundException extends RuntimeException {
    public ChatNotFoundException(Long id){
        super("Could not find chat: " + id);
    }
}
