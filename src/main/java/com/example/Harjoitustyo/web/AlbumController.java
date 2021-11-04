package com.example.Harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Harjoitustyo.domain.Album;
import com.example.Harjoitustyo.domain.AlbumRepository;

@Controller
public class AlbumController {

	@Autowired
	private AlbumRepository repository;

	@RequestMapping(value = "/albumlist")
	public String muiscList(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "albumlist";
	}

	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	public @ResponseBody List<Album> albumListRest() {
		return (List<Album>) repository.findAll();
	}

	@RequestMapping(value = "/albums/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Album> findAlbumRest(@PathVariable("id") Long albumId) {
		return repository.findById(albumId);
	}

	@RequestMapping(value = "/albums", method = RequestMethod.POST)
	public @ResponseBody Album saveAlbumRest(@RequestBody Album album) {
		return repository.save(album);

	}

}
