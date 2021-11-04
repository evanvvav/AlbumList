package com.example.Harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Harjoitustyo.domain.Album;
import com.example.Harjoitustyo.domain.AlbumRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AlbumRepository repository) {
		return (args) -> {
			repository.save(new Album("Title 1", "Artist 1", 8, 2021));
			repository.save(new Album("Title 2", "Artist 2", 4, 1999));
			repository.save(new Album("Title 3", "Artist 3", 2, 2017));
		};
	}
}
