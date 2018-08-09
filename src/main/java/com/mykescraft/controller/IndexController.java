package com.mykescraft.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mykescraft.model.Hilt;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	
	@GetMapping("/videos.html")
	public String videos() {
		return "videos";
	}
	
	@GetMapping("/contact.html")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/lightsabers.html")
	public String lightsaber(Model model) {
		model.addAttribute("hilts", getHilts());
		return "lightsabers";
	}
	
	private ArrayList<Hilt> getHilts(){
		ArrayList<Hilt> hilts = new ArrayList<>();
		
		Hilt hilt1 = new Hilt("hilt1", "hilt", 25.23);
		Hilt hilt2 = new Hilt("hilt2", "hilt", 30.00);
		
		hilts.add(hilt1);
		hilts.add(hilt2);
		
		return hilts;
	}
	
	
}
