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
import com.mykescraft.model.Button;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Soundcard;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccessoryRepositoryTest {

	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	@Test
	public void testFindAllHilts() {
		List<Hilt> hilts = accessoryRepo.findAllHilts();
		assertNotNull(hilts);
		assertTrue(!hilts.isEmpty());
	}
	
	@Test
	public void testFindHiltById1() {
		Hilt hilt = accessoryRepo.findHiltById(1);
		assertNotNull(hilt);
	}
	
	@Test
	public void testFindHiltById2() {
		Hilt hilt = new Hilt();
		hilt = accessoryRepo.findHiltById(1);
		assertEquals(hilt.getName(), "Hilt1");
		assert(hilt.getPrice()==25);
		assertEquals(hilt.getImageUrl(), "https://i.imgur.com/AFoVY6Y.jpg");
		
	}
	
	@Test
	public void testFindAllLeds() {
		List<Led> leds = accessoryRepo.findAllLeds();
		assertNotNull(leds);
		assertTrue(!leds.isEmpty());
	}
	
	@Test
	public void testFindLedById1() {
		Led led = accessoryRepo.findLedById(4);
		assertNotNull(led);
	}
	
	@Test
	public void testFindLedById2() {
		Led led = accessoryRepo.findLedById(4);
		assertEquals(led.getName(), "Led1");
		assert(led.getPrice()==10);
		assertEquals(led.getImageUrl(), "https://i.imgur.com/KV8V36e.jpg");
	}
	
	@Test
	public void testFindAllSoundards() {
		List<Soundcard> soundcards = accessoryRepo.findAllSoundcards();
		assertNotNull(soundcards);
		assertTrue(!soundcards.isEmpty());
	}
	
	@Test
	public void testFindSoundcardById1() {
		Soundcard soundcard = accessoryRepo.findSoundcardById(8);
		assertNotNull(soundcard);
	}
	
	@Test
	public void testFindSoundcardById2() {
		Soundcard soundcard = accessoryRepo.findSoundcardById(9);
		assertEquals(soundcard.getName(), "SoundCard3");
		assert(soundcard.getPrice()==12);
		assertEquals(soundcard.getImageUrl(), "https://i.imgur.com/lESewD2.jpg");
	}
	
	@Test
	public void testFindAllButtons() {
		List<Button> buttons = accessoryRepo.findAllButtons();
		assertNotNull(buttons);
		assertTrue(!buttons.isEmpty());
	}
	
	@Test
	public void testFindButtonById1() {
		Button button = accessoryRepo.findButtonById(10);
		assertNotNull(button);
	}
	
	@Test
	public void testFindButtonById2() {
		Button button = accessoryRepo.findButtonById(12);
		assertEquals(button.getName(), "Button3");
		assert(button.getPrice()==14.5);
		assertEquals(button.getImageUrl(), "https://i.imgur.com/3PeebMf.jpg");
	}

}
