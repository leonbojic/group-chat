package com.chatapp.model;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Post> posts = new HashSet<>();
    @ManyToMany(
        mappedBy = "chats"
    )
    private Set<Member> members = new HashSet<>();

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
  
    public Set<Post> getPosts() {
        return posts;
    }
    
    public Set<Member> getMembers(){
        return members;
    }

    public void addPost(Post post){
        post.setChat(this);
        posts.add(post);
    }
    
    public void removePost(Post post){
        posts.remove(post);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public void removeMember(Member member){
        members.remove(member);
    }
}
