package com.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.data.Spittle;
import com.data.SpittleRepository;
import com.exceptions.SpittleNotFoundException;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spittleRepository;
	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute("spittle1",spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId,Model model)
	throws SQLException,ClassNotFoundException {
	Spittle spittle = spittleRepository.findOne(spittleId);
	if (spittle == null) {
	throw new SpittleNotFoundException();
	}
	model.addAttribute("spittle",spittle);
	return "spittle";
	}
}
