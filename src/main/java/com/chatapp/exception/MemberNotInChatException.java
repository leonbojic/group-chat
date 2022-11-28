package com.chatapp.exception;

public class MemberNotInChatException extends RuntimeException{
    public MemberNotInChatException(Long chatId){
        super("Member is not in Chat: "+ chatId);
    }
}
