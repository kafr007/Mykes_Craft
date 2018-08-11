package com.mykescraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;

@Controller
public class DisplayHiltController {
	
	@Autowired
	private AccessoryRepositoryImpl acRepo;
	
	@GetMapping("/lightsabers.html")
	public String lightsaber(Model model) {
		model.addAttribute("hilts", acRepo.findAllHilts());
		return "lightsabers";
	}

}
