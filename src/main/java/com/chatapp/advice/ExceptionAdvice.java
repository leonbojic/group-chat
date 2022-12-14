package com.chatapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chatapp.exception.ChatNotFoundException;
import com.chatapp.exception.MemberIsNotPosterException;
import com.chatapp.exception.MemberNotFoundException;
import com.chatapp.exception.MemberNotInChatException;
import com.chatapp.exception.PostNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
    
    @ResponseBody
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String memberNotFoundHandler(MemberNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ChatNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String chatNotFoundHandler(ChatNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String postNotFoundHandler(PostNotFoundException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MemberNotInChatException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String memberNotInChatHandler(MemberNotInChatException ex){
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MemberIsNotPosterException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    String memberIsNotPosterHandler(MemberIsNotPosterException ex){
        return ex.getMessage();
    }

    

    
}   
