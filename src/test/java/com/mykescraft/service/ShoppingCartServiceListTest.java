package com.mykescraft.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestPropertySource;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Hilt;
import com.mykescraft.service.exception.AccessoryIsNotInTheCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

public class ShoppingCartServiceListTest {
	
	@Mock
	private ShoppingCartServiceImpl  cartService;
	
	List<Accessory> testList;
	
	Hilt hilt1 = new Hilt("valami", 25.6, "http");
	Hilt hilt2 = new Hilt("valami1", 36.0, "https");
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		cartService=new ShoppingCartServiceImpl();
		testList = cartService.getList();
		testList.add(hilt1);
		testList.add(hilt2);
	}
	
	@Test
	public void testSize() {
		assertEquals("Check size", 2, testList.size());
	}
	
	@Test
	public void testIsEmpty() {
		assertFalse(testList.isEmpty());
	}
	
	@Test
	public void testAddProductToTheCart() {
		cartService.addProductToCart(new Hilt("kicsi", 35.6, "https//"));
		assertEquals("Add product", 3, testList.size());
	}
	
	@Test(expected= AccessoryIsNotInTheCart.class)
	public void testRemoveProductFromCart() throws AccessoryIsNotInTheCart {
		cartService.removeProductFromCart(new Hilt("kicsi", 35.6, "https//"));	
	}
	
	@Test
	public void testRemoveAll() {
		cartService.removeAll();
		assertTrue(testList.isEmpty());
	}
	
	@Test(expected= AccessoryTypeAlreadyInTheCartException.class)
	public void testIsAccessoryAlreadyInTheCart() throws AccessoryTypeAlreadyInTheCartException {
		cartService.isAccessoryTypeAlreadyInTheCart(hilt1);
	}
	
	@After
	public void destroy() {
		cartService.removeAll();
	}

	
}
