package com.mykescraft.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mykescraft.model.Accessory;
import com.mykescraft.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Accessory> findAllProducts() {
		List<Accessory> list = this.jdbcTemplate.query(
				"select name, price, imageUrl from accessory",
				new RowMapper<Accessory>() {
					public Accessory mapRow(ResultSet rs, int rowNum) throws SQLException{
						Accessory ac = new Accessory() {
						};
						ac.setName(rs.getString("name"));
						ac.setPrice(rs.getDouble("price"));
						ac.setImageUrl(rs.getString("imageUrl"));
						return ac;
					}
				});
		return list;
	}

	@Override
	public Accessory findProductById(Long id) {
		
		return null;
	}

}
