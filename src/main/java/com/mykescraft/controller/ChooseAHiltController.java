package com.mykescraft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mykescraft.model.Hilt;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartImpl;

@Controller
public class ChooseAHiltController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ShoppingCartImpl shoppingCartService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@GetMapping("/hilt.html")
	public String displayHilt(Model model) {
		model.addAttribute("hilts", accessoryService.findAllHilts());
		return "hilt";
	}

/*	@PostMapping("/hilt")
	public String chooseAHilt(@ModelAttribute Long id) {
		log.info("New product in the cart!");
		shoppingCartService.addProductToCart(shoppingCartService.findHiltById(id));
		return "led";
	}*/
}
