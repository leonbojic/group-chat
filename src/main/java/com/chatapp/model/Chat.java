package com.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Chat {
    private @Id @GeneratedValue Long id;
  

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true    
    )
    private List<Post> posts = new ArrayList<>();

    public Chat(){}



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  
    public List<Post> getPosts() {
        return posts;
    }
    

    public void addPost(Post post){
        posts.add(post);
    }
    
    
}
