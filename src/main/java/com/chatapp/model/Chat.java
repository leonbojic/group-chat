package com.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Chat {
    private @Id @GeneratedValue Long id;
    
    private String chatname;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();
    @ManyToMany(
        mappedBy = "chats"
    )
    private List<Member> members = new ArrayList<>();

    public Chat(){}


    public String getChatname() {
        return chatname;
    }
    public void setChatname(String chatname) {
        this.chatname = chatname;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  
    public List<Post> getPosts() {
        return posts;
    }
    
    public List<Member> getMembers(){
        return members;
    }

    public void addPost(Post post){
        posts.add(post);
    }
    
    public void addMember(Member member){
        members.add(member);
    }
    
}
