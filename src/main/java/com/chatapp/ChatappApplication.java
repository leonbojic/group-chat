package com.chatapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chatapp.model.Member;
import com.chatapp.repository.ChatRepository;
import com.chatapp.repository.PostRepository;
import com.chatapp.repository.MemberRepository;

@SpringBootApplication
public class ChatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MemberRepository userRepository, PostRepository postRepository,
	 ChatRepository chatRepository){
		return args->{
			userRepository.save(new Member("micah"));
			userRepository.save(new Member("jozo"));
			userRepository.save(new Member("bozo"));
			userRepository.save(new Member("bill"));
			userRepository.save(new Member("looser"));
		};
	}
}
