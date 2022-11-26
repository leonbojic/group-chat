package com.chatapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Friend {
    private @Id @GeneratedValue Long id;
    private String username;

    @ManyToMany
    @JoinTable(
        name = "chat_friend",
        joinColumns = @JoinColumn(name = "friend_id"),
        inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    private List<Chat> chats = new ArrayList<>();

    public Friend(){}

    public Friend(String username){
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

    public List<Chat> getChats(){
        return this.chats;
    }
    
    public void addChat(Chat chat){
        chats.add(chat);
    }


}
