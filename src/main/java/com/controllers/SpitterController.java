package com.controllers;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.data.Spitter;
import com.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpitterRepository spitterRepository;
	@Autowired
	public SpitterController(
			SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		Spitter spitter = new Spitter();
		model.addAttribute(spitter);
		return "registerForm";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,Errors errors,Model model) throws SQLException,ClassNotFoundException  {
		if (errors.hasErrors()) {
		return "registerForm";
		}
		spitterRepository.save(spitter);
		model.addAttribute(spitter);
		return "redirect:/spitter/" + spitter.getUsername();
	}
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String username, Model model) throws SQLException,ClassNotFoundException  {
	Spitter spitter = spitterRepository.findByUsername(username);
	model.addAttribute(spitter);
	return "profile";
	}
}
