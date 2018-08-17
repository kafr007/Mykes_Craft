package com.mykescraft.repositoryimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mykescraft.model.Customer;
import com.mykescraft.repository.CustomerRepository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void saveCustomerData(Customer customer) {
		String sql ="insert into customers (id, name, email, customer_address, phone_Number) values (?, ?, ?, ?,?)";
		
		jdbcTemplate.update(sql, customer.getId(), customer.getName(), customer.getEmail(), customer.getCustomerAddress(), customer.getPhoneNumber());
		
	}

}
