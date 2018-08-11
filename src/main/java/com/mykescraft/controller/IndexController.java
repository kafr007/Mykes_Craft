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
	
	
	
	/*private ArrayList<Hilt> getHilts(){
		ArrayList<Hilt> hilts = new ArrayList<>();
		
		Hilt hilt1 = new Hilt("hilt1", 25.23, "imageurl");
		Hilt hilt2 = new Hilt("hilt2", 30.00, "imageurl");
		
		hilts.add(hilt1);
		hilts.add(hilt2);
		
		return hilts;
	}*/
	
	
}
