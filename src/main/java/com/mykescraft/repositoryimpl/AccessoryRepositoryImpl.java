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
	
	private final RowMapper<Hilt> hiltMapper = new RowMapper<Hilt>() {

		@Override
		public Hilt mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hilt hilt = new Hilt();
			hilt.setName(rs.getString("name"));
			hilt.setPrice(rs.getDouble("price"));
			hilt.setImageUrl(rs.getString("image_url"));
			return hilt;
		}
		
	};
	
	private final RowMapper<Button> buttonMapper = new RowMapper<Button>() {

		@Override
		public Button mapRow(ResultSet rs, int rowNum) throws SQLException {
			Button button = new Button();
			button.setName(rs.getString("name"));
			button.setPrice(rs.getDouble("price"));
			button.setImageUrl(rs.getString("image_url"));
			return button;
		}
		
	};
	
	private final RowMapper<Blade> bladeMapper = new RowMapper<Blade>() {

		@Override
		public Blade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Blade blade = new Blade();
			blade.setName(rs.getString("name"));
			blade.setPrice(rs.getDouble("price"));
			blade.setImageUrl(rs.getString("image_url"));
			blade.setLength(rs.getDouble("length"));
			blade.setTip(rs.getString("tip"));
			blade.setWallThickness(rs.getString("walthickness"));
			return blade;
		}
		
	};
	
	private final RowMapper<Led> ledMapper = new RowMapper<Led>() {

		@Override
		public Led mapRow(ResultSet rs, int rowNum) throws SQLException {
			Led led = new Led();
			led.setName(rs.getString("name"));
			led.setPrice(rs.getDouble("price"));
			led.setImageUrl(rs.getString("image_url"));
			led.setColor(rs.getString("color"));
			return led;
		}
		
	};
	
	private final RowMapper<Soundcard> soundcardMapper = new RowMapper<Soundcard>() {

		@Override
		public Soundcard mapRow(ResultSet rs, int rowNum) throws SQLException {
			Soundcard soundcard = new Soundcard();
			soundcard.setName(rs.getString("name"));
			soundcard.setPrice(rs.getDouble("price"));
			soundcard.setImageUrl(rs.getString("image_url"));
			return soundcard;
		}
		
	};

	@Override
	public List<Blade> findAllBlades() {
		List<Blade> list = this.jdbcTemplate.query(
				"select name, price, image_url, tip, length, wallthickness from accessories",bladeMapper);
		return list;
	}

	@Override
	public List<Button> findAllButtons() {
		List<Button> list = this.jdbcTemplate.query(
				"select name, price, image_url from accessories", buttonMapper);
		return list;
	}

	@Override
	public List<Hilt> findAllHilts() {
		List<Hilt> list = this.jdbcTemplate.query(
				"select name, price, image_url from accessories", hiltMapper);
		return list;
	}

	@Override
	public List<Led> findAllLeds() {
		List<Led> list = this.jdbcTemplate.query(
				"select name, price, image_url, color from accessories", ledMapper);
		return list;
	}

	@Override
	public List<Soundcard> findAllSoundcards() {
		List<Soundcard> list = this.jdbcTemplate.query(
				"select name, price, image_url from accessories", soundcardMapper);
		return list;
	}

	@Override
	public Blade findBladeById(Long id) {
		String sql = "SELECT * FROM ACCESSORIES WHERE ID = ?";
		return (Blade) jdbcTemplate.query(sql, bladeMapper, id);
	}

	@Override
	public Button findButtonById(Long id) {
		String sql = "SELECT * FROM ACCESSORIES WHERE ID = ?";
		return (Button) jdbcTemplate.query(sql, buttonMapper, id);
	}
	
	public Hilt findHiltById(Long id) {
		String sql = "SELECT * FROM ACCESSORIES WHERE ID = ?";
		return (Hilt) jdbcTemplate.query(sql, hiltMapper, id);
	}

	@Override
	public Led findLedById(Long id) {
		String sql = "SELECT * FROM ACCESSORIES WHERE ID = ?";
		return (Led) jdbcTemplate.query(sql, ledMapper, id);
	}

	@Override
	public Soundcard findSOundcardById(Long id) {
		String sql = "SELECT * FROM ACCESSORIES WHERE ID = ?";
		return (Soundcard) jdbcTemplate.query(sql, soundcardMapper, id);
	}

}
