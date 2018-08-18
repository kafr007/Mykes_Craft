package com.mykescraft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mykescraft.model.Accessory;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

public class AddtoRemoveToCartAmountTest {
	
	@Autowired
	private ShoppingCartServiceImpl shoppingCartService;
	
	private Accessory accessory;
	
	@SuppressWarnings("deprecation")
	@Test
	public void addToSum1000() {
		System.out.println("Test1");
		accessory.setPrice(1000);
		shoppingCartService.addProductToCart(accessory);
		assertEquals(1000, shoppingCartService.getAmount());
	}
}
