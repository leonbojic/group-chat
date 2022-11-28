package com.chatapp.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id){
        super("Could not find member:" + id);
    }
}
