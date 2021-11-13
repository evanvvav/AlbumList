package com.example.Harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Harjoitustyo.domain.Album;
import com.example.Harjoitustyo.domain.AlbumRepository;
import com.example.Harjoitustyo.domain.Genre;
import com.example.Harjoitustyo.domain.GenreRepository;
import com.example.Harjoitustyo.domain.Review;
import com.example.Harjoitustyo.domain.ReviewRepository;
import com.example.Harjoitustyo.domain.User;
import com.example.Harjoitustyo.domain.UserRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AlbumRepository repository, GenreRepository genreRepository,
			ReviewRepository reviewRepository, UserRepository UserRepository) {
		return (args) -> {

			genreRepository.save(new Genre("Pop"));
			genreRepository.save(new Genre("Hip-hop and Rap"));
			genreRepository.save(new Genre("Rock"));
			genreRepository.save(new Genre("EDM"));
			genreRepository.save(new Genre("Alternative"));
			genreRepository.save(new Genre("K-Pop"));
			genreRepository.save(new Genre("Country"));
			genreRepository.save(new Genre("Classical music"));

			reviewRepository.save(new Review("1/5"));
			reviewRepository.save(new Review("2/5"));
			reviewRepository.save(new Review("3/5"));
			reviewRepository.save(new Review("4/5"));
			reviewRepository.save(new Review("5/5"));

			repository.save(new Album("Title 1", "Artist 1", 8, 2021, genreRepository.findByName("Pop").get(0),
					reviewRepository.findByName("4/5").get(0), "Good"));
			repository.save(new Album("Title 2", "Artist 2", 4, 1999, genreRepository.findByName("Alternative").get(0),
					reviewRepository.findByName("4/5").get(0), "Bad but interesting"));
			repository.save(
					new Album("Title 3", "Artist 3", 2, 2017, genreRepository.findByName("Classical music").get(0),
							reviewRepository.findByName("4/5").get(0), "Hard to say"));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

			UserRepository.save(user1);
			UserRepository.save(user2);

		};
	}
}
