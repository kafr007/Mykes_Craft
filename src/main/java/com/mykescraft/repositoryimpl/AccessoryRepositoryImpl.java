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
import com.mykescraft.model.Blade;
import com.mykescraft.model.Button;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Soundcard;
import com.mykescraft.repository.AccessoryRepository;

@Repository
public class AccessoryRepositoryImpl implements AccessoryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Accessory> findAllProducts() {
		List<Accessory> list = this.jdbcTemplate.query(
				"select name, price from accessories",
				new RowMapper<Accessory>() {
					public Accessory mapRow(ResultSet rs, int rowNum) throws SQLException{
						Accessory ac = new Accessory() {
						};
						ac.setName(rs.getString("name"));
						ac.setPrice(rs.getDouble("price"));
						return ac;
					}
				});
		return list;
	}

	@Override
	public Accessory findAccessoryById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blade> findAllBlades() {
		List<Blade> list = this.jdbcTemplate.query(
				"select name, price, length, wallthickness,tip from accessories",
				new RowMapper<Blade>() {
					public Blade mapRow(ResultSet rs, int rowNum) throws SQLException{
						Blade blade = new Blade();
						blade.setName(rs.getString("name"));
						blade.setPrice(rs.getDouble("price"));
						blade.setLength(rs.getDouble("length"));
						blade.setName(rs.getString("wallthickness"));
						blade.setName(rs.getString("tip"));
						return blade;
					}
				});
		return list;
	}


	@Override
	public List<Button> findAllButtons() {
		List<Button> list = this.jdbcTemplate.query(
				"select name, price from accessories",
				new RowMapper<Button>() {
					public Button mapRow(ResultSet rs, int rowNum) throws SQLException{
						Button button = new Button();
						button.setName(rs.getString("name"));
						button.setPrice(rs.getDouble("price"));
						return button;
					}
				});
		return list;
	}

	@Override
	public List<Hilt> findAllHilts() {
		List<Hilt> list = this.jdbcTemplate.query(
				"select name, price, image_url from accessories",
				new RowMapper<Hilt>() {
					public Hilt mapRow(ResultSet rs, int rowNum) throws SQLException{
						Hilt hilt = new Hilt();
						hilt.setName(rs.getString("name"));
						hilt.setPrice(rs.getDouble("price"));
						hilt.setImageUrl(rs.getString("image_url"));
						return hilt;
					}
				});
		return list;
	}

	@Override
	public List<Led> findAllLeds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Soundcard> findAllSoundcards() {
		// TODO Auto-generated method stub
		return null;
	}

}
