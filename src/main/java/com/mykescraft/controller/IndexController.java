package com.mykescraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
