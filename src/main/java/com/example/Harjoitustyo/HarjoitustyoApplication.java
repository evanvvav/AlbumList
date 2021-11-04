package com.example.Harjoitustyo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Harjoitustyo.domain.Album;
import com.example.Harjoitustyo.domain.AlbumRepository;
import com.example.Harjoitustyo.domain.Genre;
import com.example.Harjoitustyo.domain.GenreRepository;

@SpringBootApplication
public class HarjoitustyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AlbumRepository repository, GenreRepository genreRepository) {
		return (args) -> {

			genreRepository.save(new Genre("Pop"));
			genreRepository.save(new Genre("Hip-hop and Rap"));
			genreRepository.save(new Genre("Rock"));
			genreRepository.save(new Genre("EDM"));
			genreRepository.save(new Genre("Alternative"));
			genreRepository.save(new Genre("K-Pop"));
			genreRepository.save(new Genre("Country"));
			genreRepository.save(new Genre("Classical music"));

			repository.save(new Album("Title 1", "Artist 1", 8, 2021, genreRepository.findByName("Pop").get(0)));
			repository
					.save(new Album("Title 2", "Artist 2", 4, 1999, genreRepository.findByName("Alternative").get(0)));
			repository.save(
					new Album("Title 3", "Artist 3", 2, 2017, genreRepository.findByName("Classical music").get(0)));
		};
	}
}
