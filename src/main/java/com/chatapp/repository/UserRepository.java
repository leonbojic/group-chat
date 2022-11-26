package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Friend;

public interface UserRepository extends JpaRepository<Friend, Long> {
    
}
