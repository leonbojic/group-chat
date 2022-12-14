package com.chatapp.model;

import java.time.LocalDateTime;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Post {

    private @Id @GeneratedValue Long id;
    
    @ManyToOne()
    private Member poster;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    
    @ManyToOne(
        //cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "chatId"    
    )
    @JsonIgnore
    private Chat chat;

    public Post() {
    }

    public Post(String content) {
        this.content = content;
    }

    public Post( Member poster, String content){
        this.poster = poster;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Member getPoster() {
        return poster;
    }

    public void setUsername(Member poster) {
        this.poster = poster;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(LocalDateTime editedAt) {
        this.editedAt = editedAt;
    }


    
}
