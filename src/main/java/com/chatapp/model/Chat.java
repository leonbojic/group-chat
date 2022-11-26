package com.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Chat {
    private @Id @GeneratedValue Long id;
    private List<User> users = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();

    public Chat(){}



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<User> getUsers() {
        return users;
    }
    public List<Post> getPosts() {
        return posts;
    }
    
    public void addUser(User user){
        users.add(user);
    }
    public void addPost(Post post){
        posts.add(post);
    }
    
    
}
