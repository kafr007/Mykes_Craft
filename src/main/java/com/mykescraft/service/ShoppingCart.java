package com.mykescraft.service;

import java.util.Date;
import java.util.Set;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Order;

public interface ShoppingCart {
	
	void addProductToCart(Accessory accessory);
	
	void removeProductFromCart(Accessory accessory);
	
	void saveOrder(Order order);
	
	
}
