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
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;
	private String name;
	// private String note;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
	@JsonIgnoreProperties("review")
	private List<Album> albums;

	public Review() {
		super();
		this.name = null;
		// this.note = null;
	}

	public Review(String name) {
		super();
		this.name = name;
		// this.note = note;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String getNote() { return note; }
	 * 
	 * public void setNote(String note) { this.note = note; }
	 */

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Review [reviewId = " + reviewId + ", name =" + name + "]";
	}
}
