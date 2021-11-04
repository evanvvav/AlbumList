package com.example.Harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private int songs;
	private int year;

	public Album() {
		super();
		this.title = null;
		this.artist = null;
		this.songs = 0;
		this.year = 0;
	}

	public Album(String title, String artist, int songs, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.year = year;
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

	@Override
	public String toString() {
		return "Album id=" + id + ", title =" + title + ", artist=" + artist;
	}

}
