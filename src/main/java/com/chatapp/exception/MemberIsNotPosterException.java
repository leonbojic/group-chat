package com.chatapp.exception;

public class MemberIsNotPosterException extends RuntimeException {
    public MemberIsNotPosterException(Long id){
        super("Member is not the poster: " + id);
    }
}
