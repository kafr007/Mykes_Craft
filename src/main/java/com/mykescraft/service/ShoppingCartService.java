package com.mykescraft.service;

import java.util.Date;
import java.util.Set;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Customer;
import com.mykescraft.model.Order;
import com.mykescraft.service.exception.AccessoryIsNotInTheCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;

public interface ShoppingCartService {
	
	void addProductToCart(Accessory accessory);
	
	void removeProductFromCart(Accessory accessory) throws AccessoryIsNotInTheCart;
	
	void save(Customer customer);
	
	boolean isAccessoryTypeAlreadyInTheCart(Accessory accessory) throws AccessoryTypeAlreadyInTheCartException;
	
	boolean cartIsEmpty();
	
	void removeAll();
	
	
}
