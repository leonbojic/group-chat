package com.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatapp.model.User;
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
			User micah = userRepository.save(new User("micah"));
			User bozo = userRepository.save(new User("bozo"));
			User jozo = userRepository.save(new User("jozo"));
			
			



		};


	}

}
