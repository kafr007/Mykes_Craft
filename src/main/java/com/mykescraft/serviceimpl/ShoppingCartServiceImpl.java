package com.mykescraft.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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
import com.mykescraft.service.ShoppingCartService;
import com.mykescraft.service.exception.AccessoryIsNotInTheCart;
import com.mykescraft.service.exception.AccessoryTypeAlreadyInTheCartException;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderRepositoryImpl orderRepo;

	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	@Autowired
	private CustomerRepositoryImpl customerRepo;

	private ArrayList<Accessory> list;

	private double amount;

	public ShoppingCartServiceImpl() {
		list = new ArrayList<Accessory>();
		amount = 0;
	}

	@Override
	public boolean cartIsEmpty() {
		return list.isEmpty();
	}

	@Override
	public void removeAll() {
		amount = 0;
		list.clear();		
	}

	@Override
	public void addProductToCart(Accessory accessory) throws AccessoryTypeAlreadyInTheCartException {
		if(!isAccessoryTypeAlreadyInTheCart(accessory)) {
			list.add(accessory);
			amount += accessory.getPrice();
		}		
	}
	
	private boolean isAccessoryTypeAlreadyInTheCart(Accessory accessory) throws AccessoryTypeAlreadyInTheCartException {
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getClass().equals(accessory.getClass()))
				counter++;
		}
		if(counter!=0)
			throw  new AccessoryTypeAlreadyInTheCartException("Már van " + accessory.getClass() + " ilyen termék a kosárban");
		return counter != 0;
	}

	@Override
	public void removeProductFromCart(Accessory accessory) throws AccessoryIsNotInTheCart {
		if (!list.contains(accessory)) {
			throw new AccessoryIsNotInTheCart("Nincs ilyen termék a kosárban");
		}
		list.remove(accessory);
		amount -= accessory.getPrice();	
	}
		
	@Override
	public void save(Customer customer) {
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		log.debug("id" + order.getId());
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

	public OrderRepositoryImpl getOrderRepo() {
		return orderRepo;
	}

	public void setOrderRepo(OrderRepositoryImpl orderRepo) {
		this.orderRepo = orderRepo;
	}

	public AccessoryRepositoryImpl getAccessoryRepo() {
		return accessoryRepo;
	}

	public void setAccessoryRepo(AccessoryRepositoryImpl accessoryRepo) {
		this.accessoryRepo = accessoryRepo;
	}

	public CustomerRepositoryImpl getCustomerRepo() {
		return customerRepo;
	}

	public void setCustomerRepo(CustomerRepositoryImpl customerRepo) {
		this.customerRepo = customerRepo;
	}

}
