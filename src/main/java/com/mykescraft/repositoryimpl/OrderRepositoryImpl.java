package com.mykescraft.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mykescraft.model.Hilt;
import com.mykescraft.model.Order;
import com.mykescraft.repository.OrderRepository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
	
	@Autowired
	private CustomerRepositoryImpl customerRepo;
	
	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrder(Order order) {
			
		String sql = "insert into orders (id, amount, order_date, customer_id) values (?, ?, ?, ?)";
		String sql1 = "insert into ORDERS_ACCESSORIES (order_id, accessory_id) values ( ? ,?)";
		
		jdbcTemplate.update(sql, order.getId(), order.getAmount(), order.getOrderDate(), order.getCustomer().getId());
		
		for (int i = 0; i < order.getAccessories().size(); i++) {
			jdbcTemplate.update(sql1, order.getId(), order.getAccessories().get(i).getId());
		
		
		
	}

	
	}}
