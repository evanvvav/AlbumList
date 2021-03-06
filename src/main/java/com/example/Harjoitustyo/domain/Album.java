package com.example.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private int songs;
	private int year;
	private String note;

	@ManyToOne
	@JoinColumn(name = "genreId")
	@JsonIgnoreProperties("albums")
	private Genre genre;

	@ManyToOne
	@JoinColumn(name = "reviewId")
	@JsonIgnoreProperties("albums")
	private Review review;

	public Album() {
		super();
		this.title = null;
		this.artist = null;
		this.songs = 0;
		this.year = 0;
		this.genre = null;
		this.review = null;
		this.note = null;
	}

	public Album(String title, String artist, int songs, int year, Genre genre, Review review, String note) {
		super();
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.year = year;
		this.genre = genre;
		this.review = review;
		this.note = note;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getSongs() {
		return songs;
	}

	public void setSongs(int songs) {
		this.songs = songs;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Album id=" + id + ", title =" + title + ", artist=" + artist + ", genre=" + genre;
	}

}
