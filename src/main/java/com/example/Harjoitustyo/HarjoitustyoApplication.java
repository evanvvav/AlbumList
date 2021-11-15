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
			genreRepository.save(new Genre("Experimental"));
			genreRepository.save(new Genre("Classical music"));

			reviewRepository.save(new Review("1/5"));
			reviewRepository.save(new Review("2/5"));
			reviewRepository.save(new Review("3/5"));
			reviewRepository.save(new Review("4/5"));
			reviewRepository.save(new Review("5/5"));

			repository.save(new Album("Eternal Atake", "Lil Uzi Vert", 16, 2020,
					genreRepository.findByName("Hip-hop and Rap").get(0), reviewRepository.findByName("5/5").get(0),
					"Good"));
			repository.save(new Album("The Fool", "Bladee", 13, 2021, genreRepository.findByName("Alternative").get(0),
					reviewRepository.findByName("3/5").get(0), "Boring"));
			repository.save(new Album("Pop 2", "Charlie XCX", 10, 2017, genreRepository.findByName("Pop").get(0),
					reviewRepository.findByName("4/5").get(0), "Good"));
			repository.save(new Album("Whole Lotta Red", "Playboi Carti", 24, 2021,
					genreRepository.findByName("Hip-hop and Rap").get(0), reviewRepository.findByName("4/5").get(0),
					"Good"));
			repository.save(new Album("KiCki", "Arca", 12, 2020, genreRepository.findByName("Experimental").get(0),
					reviewRepository.findByName("4/5").get(0), "Interesting"));
			repository.save(new Album("Skin", "Flume", 10, 2016, genreRepository.findByName("EDM").get(0),
					reviewRepository.findByName("5/5").get(0), "ETC"));
			repository.save(new Album("Up 2 Me", "Yeat", 22, 2021, genreRepository.findByName("Hip-hop and Rap").get(0),
					reviewRepository.findByName("5/5").get(0), ""));
			repository.save(new Album("Hybrid Theory", "Linkin Park", 12, 2000,
					genreRepository.findByName("Rock").get(0), reviewRepository.findByName("5/5").get(0), ""));
			repository.save(new Album("Enema Of The State", "blink-182", 12, 1999,
					genreRepository.findByName("Rock").get(0), reviewRepository.findByName("3/5").get(0), ""));
			repository.save(new Album("Warlord", "Yung Lean", 19, 2016, genreRepository.findByName("Rock").get(0),
					reviewRepository.findByName("4/5").get(0), ""));
			repository.save(new Album("Castles 2", "Lil Peep, Lil Tracy", 4, 2017,
					genreRepository.findByName("Alternative").get(0), reviewRepository.findByName("5/5").get(0), ""));
			repository.save(new Album("E", "Ecco2k", 12, 2019, genreRepository.findByName("Experimental").get(0),
					reviewRepository.findByName("5/5").get(0), ""));
			repository.save(new Album("Art Angels", "Grimes", 14, 2015, genreRepository.findByName("Pop").get(0),
					reviewRepository.findByName("5/5").get(0), ""));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

			UserRepository.save(user1);
			UserRepository.save(user2);

		};

	}
}
