package com.example.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Harjoitustyo.domain.Review;
import com.example.Harjoitustyo.domain.ReviewRepository;

@Controller
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;

	public String reviewList(Model model) {
		model.addAttribute("review", reviewRepository.findAll());
		return "reviewlist";
	}

	@RequestMapping(value = "/addreview")
	public String addReview(Model model) {
		model.addAttribute("review", new Review());
		return "addreview";

	}

	@RequestMapping(value = "/savereview", method = RequestMethod.POST)
	public String save(Review review) {
		reviewRepository.save(review);
		return "redirect:/reviewlist";

	}

}
