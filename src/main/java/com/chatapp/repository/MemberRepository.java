package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
