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
	public long saveCustomerData(Customer customer) {
		String sql ="insert into customers (name, email, customer_address, phone_Number) values (?, ?, ?, ?)";
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
		      @Override
		      public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
		        final PreparedStatement ps = connection.prepareStatement(sql,
		            Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, customer.getName());
		        ps.setString(2, customer.getEmail());
		        ps.setString(3, customer.getCustomerAddress());
		        ps.setString(4, customer.getPhoneNumber());
		        return ps;
		      }
		    };

		    // The newly generated key will be saved in this object
		    final KeyHolder holder = new GeneratedKeyHolder();

		    jdbcTemplate.update(psc, holder);

		    final long id = holder.getKey().longValue();
		    log.info("id " + id);
		return id;
	}

}
