package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
    
}