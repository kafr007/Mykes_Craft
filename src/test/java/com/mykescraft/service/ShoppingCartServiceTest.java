package com.mykescraft.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

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
	
	@Mock
	private ShoppingCartServiceImpl  cartService;
		
	private ArrayList<Accessory> list;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		cartService=new ShoppingCartServiceImpl();
		cartService.setList(list);
		list.add(new Hilt("valami", 25.6, "http"));
		list.add(new Hilt("valami1", 36.0, "https"));
	}
	
	

}
