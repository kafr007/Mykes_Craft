package com.mykescraft.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.hibernate.type.UUIDCharType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Customer;
import com.mykescraft.model.Order;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.repositoryimpl.CustomerRepositoryImpl;
import com.mykescraft.repositoryimpl.OrderRepositoryImpl;
import com.mykescraft.service.ShoppingCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;

@Service
public class ShoppingCartImpl implements ShoppingCart {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderRepositoryImpl orderRepo;

	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;
	
	@Autowired
	private CustomerRepositoryImpl customerRepo;

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
	
	@Override
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
	public void save(Customer customer) {
		log.info(customer.toString());
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		log.info("id" + order.getId());
		customer.setId(UUID.randomUUID().toString());
		customerRepo.saveCustomerData(customer);
		order.setAmount(amount);
		order.setOrderDate(new Date());
		order.setCustomer(customer);
		order.setAccessories(list);
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
