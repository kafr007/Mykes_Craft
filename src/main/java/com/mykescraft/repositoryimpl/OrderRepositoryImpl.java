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
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrder(Order order) {
		final String sql = "INSERT INTO orders (accessories, orderdate, customerName, customerAddress, customerEmail, customerPhone) VALUES (?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, order.getAccessories(), order.getOrderDate(), order.getCustomerName(), order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
	}

}
