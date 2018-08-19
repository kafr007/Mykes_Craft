package com.mykescraft.controller;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Customer;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.CustomerRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

@Controller
public class CustomizeLightsaberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ShoppingCartServiceImpl shoppingCartService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@GetMapping("/hilt")
	public String displayHilt(Model model) {
		model.addAttribute("hilts", accessoryService.findAllHilts());
		log.debug("Hiltbe beléptem");
		log.debug("list.size" + shoppingCartService.getList().size());
		shoppingCartService.removeAll();
		;
		log.debug("list.size" + shoppingCartService.getList().size());
		return "hilt";
	}

	@RequestMapping({ "/chooseahilt" })
	public String chooseAHilt(HttpServletRequest request, Model model,
			@RequestParam(value = "id", defaultValue = "") String id) {

		log.debug("hilt id" + id);
		Hilt hilt = accessoryService.findHiltById(Integer.parseInt(id));
		log.debug(hilt.getName());
		log.debug("hilt price" + hilt.getPrice());
		try {
			shoppingCartService.addProductToCart(hilt);
			log.info("led list.size" + shoppingCartService.getList().size());
			log.info("led price" + shoppingCartService.getAmount());
		} catch (AccessoryTypeAlreadyInTheCartException e) {
			e.printStackTrace();
		}
		return "redirect:/led";
	}

	@GetMapping("/led")
	public String displayLed(Model model) {
		model.addAttribute("leds", accessoryService.findAllLeds());

		log.debug("list.size" + shoppingCartService.getList().size());
		return "led";
	}

	@RequestMapping({ "/choosealed" })
	public String chooseALed(HttpServletRequest request, Model model,
			@RequestParam(value = "id", defaultValue = "") String id) {
		log.debug("Beléptem a ledbe");
		log.debug("led id" + id);
		Led led = accessoryService.findLedById(Integer.parseInt(id));
		log.debug(led.getName());
		log.debug("" + led.getPrice());
		try {
			shoppingCartService.addProductToCart(led);
			log.debug("led list.size" + shoppingCartService.getList().size());
			log.debug("led price" + shoppingCartService.getAmount());

		} catch (AccessoryTypeAlreadyInTheCartException e) {
			e.printStackTrace();
		}
		return "redirect:/cartconfirmation";
	}

	@GetMapping("/cartconfirmation")
	public String displayCart(Model model) {
		model.addAttribute("accessories", shoppingCartService.getList());
		model.addAttribute("amount", shoppingCartService.getAmount());
		log.debug("" + shoppingCartService.getList());
		return "cartconfirmation";
	}

	@GetMapping(value = { "/customer-form" })
	public String getCustomerData(@ModelAttribute("customerform") Customer customer) {
			return "customer-form";
	}

	@PostMapping(value = { "/customerdata" })
	public String customerData(@ModelAttribute("customerform") @Valid Customer customer, 
			BindingResult result, HttpServletResponse response) {
		if(result.hasErrors()) {
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			result.reject("subscirptionForm.error.incompleteInput");
			return "customer-form";
		}
		else {
			log.info("Customer: " + customer.toString());
			shoppingCartService.save(customer);
			return "redirect:/thankyou";
		}
	}

	@GetMapping(value = { "/thankyou" })
	public String thankYouOrder(Model model) {
		return "thankyou";
	}
}
