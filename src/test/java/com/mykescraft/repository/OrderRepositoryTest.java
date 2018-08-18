package com.mykescraft.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Customer;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.serviceimpl.ShoppingCartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	private OrderRepositoryImpl orderRepo;
	
	private Order order;
	
	@Mock
	private Customer customer;
	
	@Mock
	ArrayList<Accessory> accessories;	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		order.setId(UUID.randomUUID().toString());
		order.setAmount(260.25);
		order.setCustomer(customer);
		order.setAccessories(accessories);
		order.setOrderDate(new Date());
	}
	
	//FIXME write tests for orderrepo
	
}
