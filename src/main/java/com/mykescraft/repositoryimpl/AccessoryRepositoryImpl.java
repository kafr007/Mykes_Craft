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
	
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;
	
	private final RowMapper<Hilt> hiltMapper = new RowMapper<Hilt>() {

		@Override
		public Hilt mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hilt hilt = new Hilt();
			hilt.setId(rs.getLong("id"));
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
			button.setId(rs.getLong("id"));
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
			blade.setId(rs.getLong("id"));
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
			led.setId(rs.getLong("id"));
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
			soundcard.setId(rs.getLong("id"));
			soundcard.setName(rs.getString("name"));
			soundcard.setPrice(rs.getDouble("price"));
			soundcard.setImageUrl(rs.getString("image_url"));
			return soundcard;
		}
		
	};

	@Override
	public ArrayList<Blade> findAllBlades() {
		ArrayList<Blade> list = (ArrayList<Blade>) this.jdbcTemplate.query(
				"select id, name, price, image_url, tip, length, wallthickness from accessories where accessory_type='blade'",bladeMapper);
		return list;
	}

	@Override
	public ArrayList<Button> findAllButtons() {
		ArrayList<Button> list = (ArrayList<Button>) this.jdbcTemplate.query(
				"select id, name, price, image_url from accessories where accessory_type='button'", buttonMapper);
		return list;
	}

	@Override
	public ArrayList<Hilt> findAllHilts() {
		ArrayList<Hilt> list = (ArrayList<Hilt>) this.jdbcTemplate.query(
				"select id, name, price, image_url from accessories where accessory_type='hilt'", hiltMapper);
		return list;
	}

	@Override
	public ArrayList<Led> findAllLeds() {
		ArrayList<Led> list = (ArrayList<Led>) this.jdbcTemplate.query(
				"select id, name, price, image_url, color from accessories where accessory_type='led'", ledMapper);
		return list;
	}

	@Override
	public ArrayList<Soundcard> findAllSoundcards() {
		ArrayList<Soundcard> list = (ArrayList<Soundcard>) this.jdbcTemplate.query(
				"select id, name, price, image_url from accessories where accessory_type='soundcard'", soundcardMapper);
		return list;
	}

	@Override
	public Blade findBladeById(long id) {
		String sql = "select id, name, price, image_url, tip, length, wallthickness from accessories WHERE ID = ?";
		return (Blade) jdbcTemplate.queryForObject(sql, bladeMapper, id);
	}

	@Override
	public Button findButtonById(long id) {
		String sql = "select id, name, price, image_url from accessories WHERE ID = ?";
		return (Button) jdbcTemplate.queryForObject(sql, buttonMapper, id);
	}
	
	public Hilt findHiltById(long id) {
		String sql = "select id, name, price, image_url from accessories WHERE ID = ?";
		return (Hilt) jdbcTemplate.queryForObject(sql, hiltMapper, id);
	}

	@Override
	public Led findLedById(long id) {
		String sql = "select id, name, price, image_url, color from accessories WHERE ID = ?";
		return (Led) jdbcTemplate.queryForObject(sql, ledMapper, id);
	}

	@Override
	public Soundcard findSOundcardById(long id) {
		String sql = "select id, name, price, image_url from accessories WHERE ID = ?";
		return (Soundcard) jdbcTemplate.queryForObject(sql, soundcardMapper, id);
	}
	
	
	public void saveHilt(String name, double price, String imageUrl, String accessory_type) {
		String sql = "insert into accessories(name, price, image_url, accessory_type) values ('"+ name + "','" + price + "','" + imageUrl + "','" + accessory_type + "')";
		jdbcTemplate.update(sql);
	}


}
