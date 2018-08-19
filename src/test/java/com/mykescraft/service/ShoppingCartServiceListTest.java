package com.mykescraft.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Button;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.service.exception.AccessoryIsNotInTheCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

public class ShoppingCartServiceListTest {
	
	@MockBean
	private ShoppingCartServiceImpl  cartService;
	
	List<Accessory> testList;
	
	
	
	Hilt hilt = new Hilt("valami", 25.6, "http");
	Led led = new Led("led", 30.6, "http", "red");
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		cartService=new ShoppingCartServiceImpl();
		testList = cartService.getList();
		testList.add(hilt);
		testList.add(led);
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
	public void testAddProductToTheCart() throws AccessoryTypeAlreadyInTheCartException {
		cartService.addProductToCart(new Button("kicsi", 35.6, "https//"));
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
		cartService.addProductToCart(hilt);;
	}
	
	@After
	public void destroy() {
		cartService.removeAll();
	}

	
}
