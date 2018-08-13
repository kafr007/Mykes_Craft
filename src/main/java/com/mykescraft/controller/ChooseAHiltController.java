package com.mykescraft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mykescraft.serviceimpl.AccessoryServiceImpl;

@Controller
public class ChooseAHiltController {
	
	@Autowired
	private AccessoryServiceImpl accessoryService;
	
	@GetMapping("/lightsabers.html")
	public String displayHilt(Model model) {
		model.addAttribute("hilts", accessoryService.findAllHilts());
		return "lightsabers";
	}
	
	@PostMapping("/lightsabers.html" )
	public String chooseAHilt(Model model) {
		model.addAttribute("hilts", accessoryService.findAllHilts());
		return "lightsabers";
	}

}
