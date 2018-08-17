package com.mykescraft.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.service.ShoppingCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;

@Service
public class ShoppingCartImpl implements ShoppingCart {

	@Autowired
	private OrderRepositoryImpl orderRepo;

	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	private ArrayList<Accessory> list;

	private double amount;

	public ShoppingCartImpl() {
		list = new ArrayList<Accessory>();
		amount = 0;
	}

	
	@Override
	public void addProductToCart(Accessory accessory){
		list.add(accessory);
		amount += accessory.getPrice();
			
	}
	
	public boolean isAccessoryTypeAlreadyInTheCart(Accessory accessory) {
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getClass().equals(accessory.getClass()))
				counter++;
		}
		
		return counter!=0;
		
	}

	@Override
	public void removeProductFromCart(Accessory accessory) {
		list.remove(accessory);
		amount -=accessory.getPrice();
	}
	
	

	@Override
	public void saveOrder(Order order) {
		orderRepo.saveOrder(order);
	}

	public ArrayList<Accessory> getList() {
		return list;
	}

	public void setList(ArrayList<Accessory> list) {
		this.list = list;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
