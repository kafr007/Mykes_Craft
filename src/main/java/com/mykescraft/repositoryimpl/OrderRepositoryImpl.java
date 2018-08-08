package com.mykescraft.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mykescraft.model.Order;
import com.mykescraft.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById() {
		// TODO Auto-generated method stub
		return null;
	}

}
