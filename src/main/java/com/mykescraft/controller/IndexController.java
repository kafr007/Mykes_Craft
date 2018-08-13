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
	
}
