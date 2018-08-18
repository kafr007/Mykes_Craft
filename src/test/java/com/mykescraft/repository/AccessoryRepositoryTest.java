package com.mykescraft.repository;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mykescraft.MykesCraftApplication;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccessoryRepositoryTest {

	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	@Test
	public void findAllHilt() {
		List<Hilt> hilts = accessoryRepo.findAllHilts();
		assertNotNull(hilts);
		assertTrue(!hilts.isEmpty());
	}
	
	@Test
	public void findHiltById1() {
		Hilt hilt = accessoryRepo.findHiltById(1);
		assertNotNull(hilt);
	}
	
	@Test
	public void findHiltById2() {
		Hilt hilt = new Hilt();
		hilt = accessoryRepo.findHiltById(1);
		assertEquals(hilt.getName(), "Boros");
		assert(hilt.getPrice()==25);
		assertEquals(hilt.getImageUrl(), "https://i.imgur.com/AFoVY6Y.jpg");
		
	}
	
	@Test
	public void findAllLed() {
		List<Led> leds = accessoryRepo.findAllLeds();
		assertNotNull(leds);
		assertTrue(!leds.isEmpty());
	}
	
	@Test
	public void findHLedById1() {
		Led led = accessoryRepo.findLedById(4);
		assertNotNull(led);
	}
	
	@Test
	public void findHLedById2() {
		Led led = accessoryRepo.findLedById(4);
		assertEquals(led.getName(), "Red");
		assert(led.getPrice()==10);
		assertEquals(led.getImageUrl(), "https://i.imgur.com/KV8V36e.jpg");
	}

}
