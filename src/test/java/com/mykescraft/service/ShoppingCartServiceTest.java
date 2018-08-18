package com.mykescraft.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

public class ShoppingCartServiceTest {
	
	@Autowired
	private ShoppingCartServiceImpl  cartService;
	
	@Mock
	private OrderRepositoryImpl orderRepo;
	
	@Mock
	private Order order;
	
	@Mock
	private Led led;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		cartService=new ShoppingCartServiceImpl();
		cartService.setOrderRepo(orderRepo);
	}
	
	

}
