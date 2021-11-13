package com.example.Harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Harjoitustyo.web.AlbumController;
import com.example.Harjoitustyo.web.GenreController;
import com.example.Harjoitustyo.web.ReviewController;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class SmokeTestControllers {

	@Autowired
	private AlbumController albumController;

	@Autowired
	private GenreController genreController;

	@Autowired
	private ReviewController reviewController;

	public void contextLoadsAlbumControlle() throws Exception {
		assertThat(albumController).isNotNull();
	}

	public void contextLoadsGenreController() throws Exception {
		assertThat(genreController).isNotNull();
	}

	public void contextLoadsReviewController() throws Exception {
		assertThat(reviewController).isNotNull();
	}

}
