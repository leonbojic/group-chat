package com.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String username;

    List<Chat> chats = new ArrayList<>();
    
    public User(){}

    public User(String username){
        this.username =username;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public List<Chat> getChats() {
        return chats;
    }
    public void addChat(Chat chat){
        chats.add(chat);
    }
    


}
