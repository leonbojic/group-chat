package com.chatapp.service;

public interface ExceptionService {
    void checkIfExists(Long memberId);

    void checkIfExists(Long memberId, Long chatId);

    void checkIfExists(Long memberId, Long chatId, Long postId);

}
