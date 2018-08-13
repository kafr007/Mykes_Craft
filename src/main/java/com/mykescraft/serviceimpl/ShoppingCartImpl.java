package com.mykescraft.serviceimpl;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.service.ShoppingCart;

@Service
public class ShoppingCartImpl implements ShoppingCart {
	
	@Autowired
	private OrderRepositoryImpl orderRepo;
	
	private Set<Accessory> shoppingCartItems;

	@Override
	public void addProductToCart(Accessory accessory) {
		shoppingCartItems.add(accessory);
	}

	@Override
	public void removeProductFromCart(Accessory accessory) {
		shoppingCartItems.remove(accessory);
	}

	@Override
	public void saveOrder(Order order) {
		orderRepo.saveOrder(order);	
	}
	
	
}
