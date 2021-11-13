package com.example.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Harjoitustyo.domain.Album;
import com.example.Harjoitustyo.domain.AlbumRepository;
import com.example.Harjoitustyo.domain.Genre;
import com.example.Harjoitustyo.domain.GenreRepository;

@ExtendWith(SpringExtension.class)

@DataJpaTest
public class AlbumRepositoryTest {

	@Autowired
	private AlbumRepository repository;

	@Autowired
	private GenreRepository genreRepository;

	@Test
	public void findByTitleShouldReturnAlbum() {
		List<Album> albums = repository.findByTitle("Eternal Atake");
		assertThat(albums).hasSize(1);
		assertThat(albums.get(0).getArtist()).isEqualTo("Lil Uzi Vert");
	}

	@Test
	public void createNewAlbum() {
		Album album = new Album("Eternal Atake", "Lil Uzi Vert", 16, 2020, null, null, "Good");
		repository.save(album);
		assertThat(album.getId()).isNotNull();
	}

	@Test
	public void findByNameShouldReturnGenre() {
		List<Genre> genres = genreRepository.findByName("Pop");
		assertThat(genres).hasSize(1);
		assertThat(genres.get(0).getGenreId()).isEqualTo(1);

	}

}
