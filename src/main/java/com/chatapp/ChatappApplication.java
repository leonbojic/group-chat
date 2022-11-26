package com.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatapp.model.Chat;
import com.chatapp.model.Friend;
import com.chatapp.model.Post;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.repository.UserRepository;

@SpringBootApplication
public class ChatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, PostRepository postRepository, ChatRepository chatRepository){
		return args->{
			Friend micah = userRepository.save(new Friend("micah"));
			Friend bozo = userRepository.save(new Friend("bozo"));
			Friend jozo = userRepository.save(new Friend("jozo"));
			
			Chat chat1 = chatRepository.save(new Chat());
			chat1.addPost(new Post("hello"));
			chat1.addPost(new Post("belloo"));

			chat1.addFriend(jozo);
			chat1.addFriend(bozo);

			jozo.addChat(chat1);
			bozo.addChat(chat1);

			userRepository.save(bozo);

			Chat chat2 = chatRepository.save(new Chat());
			chat2.addPost(new Post("sup breh"));
			chat2.addPost(new Post("not much"));
			chat2.addPost(new Post("hbout u?"));

			chat2.addFriend(jozo);
			chat2.addFriend(micah);

			userRepository.save(micah);
			userRepository.save(jozo);

			chatRepository.save(chat1);
			chatRepository.save(chat2);

			
			



		};


	}

}
