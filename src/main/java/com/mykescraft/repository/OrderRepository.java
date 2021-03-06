package com.mykescraft.repository;

import java.util.List;

import com.mykescraft.model.Customer;
import com.mykescraft.model.Order;

public interface OrderRepository {
	
	List<Order> findAllOrder();
	
	Order findOrderById(int id);
	
	void saveOrder(Order order);
			
}
