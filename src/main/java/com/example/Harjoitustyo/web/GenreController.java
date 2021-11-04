package com.example.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Harjoitustyo.domain.Genre;
import com.example.Harjoitustyo.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepository;

	public String genreList(Model model) {

		model.addAttribute("genres", genreRepository.findAll());
		return "genrelist";

	}

	@RequestMapping(value = "/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "addgenre";
	}

	@RequestMapping(value = "/savegenre", method = RequestMethod.POST)
	public String save(Genre genre) {
		genreRepository.save(genre);
		return "redirect:/genrelist";

	}

}
