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
	
	private final String ID = "id";
	private final String NAME = "name";
	private final String PRICE = "price";
	private final String IMAGEURL = "image_url";
	private final String LENGTH = "length";
	private final String TIP = "tip";
	private final String WALLTHICKNESS = "walthickness";
	private final String COLOR = "color";
	
	private final String FINDALLBLADESQL = "select id, name, price, image_url, tip, length, wallthickness from accessories where accessory_type='blade'";
	private final String FINDALLBUTTONSQL = "select id, name, price, image_url from accessories where accessory_type='button'";
	private final String FINDALLHILTSQL = "select id, name, price, image_url from accessories where accessory_type='hilt'";
	private final String FINDALLLEDSQL = "select id, name, price, image_url, color from accessories where accessory_type='led'";
	private final String FINDALLSOUNDCARDSQL = "select id, name, price, image_url from accessories where accessory_type='soundcard'";
	
	private final String FINDBLADEBYIDSQL = "select id, name, price, image_url, tip, length, wallthickness from accessories WHERE ID = ?";
	private final String FINDBUTTONBYIDSQL = "select id, name, price, image_url from accessories WHERE ID = ?";
	private final String FINDHILTBYIDSQL = "select id, name, price, image_url from accessories WHERE ID = ?";
	private final String FINDLEDBYIDSQL = "select id, name, price, image_url, color from accessories WHERE ID = ?";
	private final String FINDSOUNDCARDBYIDSQL = "select id, name, price, image_url from accessories WHERE ID = ?";
	
	private final RowMapper<Hilt> hiltMapper = new RowMapper<Hilt>() {

		@Override
		public Hilt mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hilt hilt = new Hilt();
			hilt.setId(rs.getLong(ID));
			hilt.setName(rs.getString(NAME));
			hilt.setPrice(rs.getDouble(PRICE));
			hilt.setImageUrl(rs.getString(IMAGEURL));
			return hilt;
		}
		
	};
	
	private final RowMapper<Button> buttonMapper = new RowMapper<Button>() {

		@Override
		public Button mapRow(ResultSet rs, int rowNum) throws SQLException {
			Button button = new Button();
			button.setId(rs.getLong(ID));
			button.setName(rs.getString(NAME));
			button.setPrice(rs.getDouble(PRICE));
			button.setImageUrl(rs.getString(IMAGEURL));
			return button;
		}
		
	};
	
	private final RowMapper<Blade> bladeMapper = new RowMapper<Blade>() {

		@Override
		public Blade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Blade blade = new Blade();
			blade.setId(rs.getLong(ID));
			blade.setName(rs.getString(NAME));
			blade.setPrice(rs.getDouble(PRICE));
			blade.setImageUrl(rs.getString(IMAGEURL));
			blade.setLength(rs.getDouble(LENGTH));
			blade.setTip(rs.getString(TIP));
			blade.setWallThickness(rs.getString(WALLTHICKNESS));
			return blade;
		}
		
	};
	
	private final RowMapper<Led> ledMapper = new RowMapper<Led>() {

		@Override
		public Led mapRow(ResultSet rs, int rowNum) throws SQLException {
			Led led = new Led();
			led.setId(rs.getLong(ID));
			led.setName(rs.getString(NAME));
			led.setPrice(rs.getDouble(PRICE));
			led.setImageUrl(rs.getString(IMAGEURL));
			led.setColor(rs.getString(COLOR));
			return led;
		}
		
	};
	
	private final RowMapper<Soundcard> soundcardMapper = new RowMapper<Soundcard>() {

		@Override
		public Soundcard mapRow(ResultSet rs, int rowNum) throws SQLException {
			Soundcard soundcard = new Soundcard();
			soundcard.setId(rs.getLong(ID));
			soundcard.setName(rs.getString(NAME));
			soundcard.setPrice(rs.getDouble(PRICE));
			soundcard.setImageUrl(rs.getString(IMAGEURL));
			return soundcard;
		}
		
	};

	@Override
	public ArrayList<Blade> findAllBlades() {
		ArrayList<Blade> list = (ArrayList<Blade>) this.jdbcTemplate.query(
				FINDALLBLADESQL,bladeMapper);
		return list;
	}

	@Override
	public ArrayList<Button> findAllButtons() {
		ArrayList<Button> list = (ArrayList<Button>) this.jdbcTemplate.query(
				FINDALLBUTTONSQL, buttonMapper);
		return list;
	}

	@Override
	public ArrayList<Hilt> findAllHilts() {
		ArrayList<Hilt> list = (ArrayList<Hilt>) this.jdbcTemplate.query(
				FINDALLHILTSQL, hiltMapper);
		return list;
	}

	@Override
	public ArrayList<Led> findAllLeds() {
		ArrayList<Led> list = (ArrayList<Led>) this.jdbcTemplate.query(
				FINDALLLEDSQL, ledMapper);
		return list;
	}

	@Override
	public ArrayList<Soundcard> findAllSoundcards() {
		ArrayList<Soundcard> list = (ArrayList<Soundcard>) this.jdbcTemplate.query(
				FINDALLSOUNDCARDSQL, soundcardMapper);
		return list;
	}

	@Override
	public Blade findBladeById(long id) {
		return (Blade) jdbcTemplate.queryForObject(FINDBLADEBYIDSQL, bladeMapper, id);
	}

	@Override
	public Button findButtonById(long id) {
		return (Button) jdbcTemplate.queryForObject(FINDBUTTONBYIDSQL, buttonMapper, id);
	}
	
	public Hilt findHiltById(long id) {
		return (Hilt) jdbcTemplate.queryForObject(FINDHILTBYIDSQL, hiltMapper, id);
	}

	@Override
	public Led findLedById(long id) {
		return (Led) jdbcTemplate.queryForObject(FINDLEDBYIDSQL, ledMapper, id);
	}

	@Override
	public Soundcard findSOundcardById(long id) {
		return (Soundcard) jdbcTemplate.queryForObject(FINDSOUNDCARDBYIDSQL, soundcardMapper, id);
	}
	
	
	public void saveHilt(String name, double price, String imageUrl, String accessory_type) {
		String sql = "insert into accessories(name, price, image_url, accessory_type) values ('"+ name + "','" + price + "','" + imageUrl + "','" + accessory_type + "')";
		jdbcTemplate.update(sql);
	}


}
