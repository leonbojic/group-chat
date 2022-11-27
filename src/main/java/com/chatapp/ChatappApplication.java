package com.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatapp.model.Chat;
import com.chatapp.model.Member;
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
			Member micah = userRepository.save(new Member("micah"));
			Member bozo = userRepository.save(new Member("bozo"));
			Member jozo = userRepository.save(new Member("jozo"));
			
			Chat chat1 = chatRepository.save(new Chat());
			chat1.addPost(new Post("hello"));
			chat1.addPost(new Post("belloo"));

			chat1.addMember(jozo);
			chat1.addMember(bozo);

			jozo.addChat(chat1);
			bozo.addChat(chat1);

			userRepository.save(jozo);
			userRepository.save(bozo);

			Chat chat2 = chatRepository.save(new Chat());
			chat2.addPost(new Post("sup breh"));
			chat2.addPost(new Post("not much"));
			chat2.addPost(new Post("hbout u?"));

			chat2.addMember(jozo);
			chat2.addMember(micah);

			jozo.addChat(chat2);
			micah.addChat(chat2);

			userRepository.save(micah);
			userRepository.save(jozo);


			chat1.setChatname("jozo,bozo");
			chat2.setChatname("jozo,micah");
			chatRepository.save(chat1);
			chatRepository.save(chat2);

			
			



		};


	}

}
