package com.mykescraft.controller;

import java.util.ArrayList;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartImpl;

@Controller
public class ChooseAccessoriesController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ShoppingCartImpl shoppingCartService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@GetMapping("/hilt")
	public String displayHilt(Model model) {
		model.addAttribute("hilts", accessoryService.findAllHilts());
		log.info("Hiltbe beléptem");
		return "hilt";
	}

	 @RequestMapping({"/chooseahilt" })
	public String chooseAHilt(HttpServletRequest request, Model model, @RequestParam(value = "id", defaultValue = "") String id) {
		log.info("" + id);
		Hilt hilt = accessoryService.findHiltById(Integer.parseInt(id));
		log.info(hilt.getName());
		log.info(""+hilt.getPrice());
		shoppingCartService.addProductToCart(hilt);;
		log.info(shoppingCartService.getList().isEmpty()?"Üres":"Nem üres");
		log.info(""+ shoppingCartService.getAmount());
		return "redirect:/led";
	}
	 
	 @GetMapping("/led")
		public String displayLed(Model model) {
		 	Led led = new Led();
		 	model.addAttribute("led", led);
			model.addAttribute("leds", accessoryService.findAllLeds());
			
			log.info(""+accessoryService.findAllLeds().size());
			return "led";
		}
	 
	 @RequestMapping({"/choosealed" })
		public String chooseALed(HttpServletRequest request, Model model, @RequestParam(value = "id", defaultValue = "") String id) {
			log.info("" + id);
			Led led = accessoryService.findLedById(Integer.parseInt(id));
			log.info(led.getName());
			log.info(""+led.getPrice());
			shoppingCartService.addProductToCart(led);;
			log.info(shoppingCartService.getList().isEmpty()?"Üres":"Nem üres");
			log.info(""+ shoppingCartService.getAmount());
			return "redirect:/contact";
		}
}
