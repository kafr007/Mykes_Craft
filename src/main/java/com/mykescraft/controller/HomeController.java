package com.mykescraft.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mykescraft.model.Hilt;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	
	@GetMapping("/videos")
	public String videos() {
		return "videos";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
}
