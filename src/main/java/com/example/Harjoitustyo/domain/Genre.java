package com.example.Harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long genreId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	@JsonIgnoreProperties("genre")
	private List<Album> albums;

	public Genre() {
		super();
		this.name = null;
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long Genre) {
		this.genreId = Genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Genre [genreID=" + genreId + ", name =" + name + "]";
	}

}
