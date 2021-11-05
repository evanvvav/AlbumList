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
	private String rate;
	private String note;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
	@JsonIgnoreProperties("review")
	private List<Album> albums;

}
