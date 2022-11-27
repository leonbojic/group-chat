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
import com.chatapp.repository.MemberRepository;

@SpringBootApplication
public class ChatappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	
	CommandLineRunner commandLineRunner(MemberRepository userRepository, PostRepository postRepository, ChatRepository chatRepository){
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

	@Bean
	CommandLineRunner commandLineRunner2(MemberRepository userRepository, PostRepository postRepository, ChatRepository chatRepository){
		return args->{
			Member micah = userRepository.save(new Member("micah"));
			Member bozo = userRepository.save(new Member("bozo"));
			Member jozo = userRepository.save(new Member("jozo"));
			Member bill = userRepository.save(new Member("bill"));

			Chat chat1 = new Chat();
			
			chat1.addMember(micah);
			chat1.addMember(bozo);
			
			chat1.addPost(new Post(micah, "hey Bozo"));
			micah.addChat(chat1);
			
			chat1.addPost(new Post(bozo, "bello"));
			bozo.addChat(chat1);


			chat1.setChatname("micah and bozo");
			chatRepository.save(chat1);
		};
	}

}
