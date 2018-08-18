package com.mykescraft.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Customer;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.CustomerRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired
	private CustomerRepositoryImpl customerRepo;
	
	@Mock
	private Order order;
	
	private Customer customer;
		
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		customer.setId(UUID.randomUUID().toString());
		customer.setCustomerAddress("hungary");
		customer.setEmail("djfdkfjkd@gmail.com");
		customer.setName("Kiss Józsi");
		customer.setOrder(order);
		customer.setPhoneNumber("062856565656");
	}
	
	//FIXME write test for customerrepo

}
