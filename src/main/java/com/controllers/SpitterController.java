package com.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.Part;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(
			@RequestPart("profilePicture") Part profilePicture,@Valid Spitter spitter,Errors errors,Model model)
					throws SQLException,ClassNotFoundException,IOException  {
		if (errors.hasErrors()) {
		return "registerForm";
		}
		profilePicture.write(profilePicture.getSubmittedFileName());
		//profilePicture.transferTo(new File(profilePicture.getOriginalFilename()));
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
