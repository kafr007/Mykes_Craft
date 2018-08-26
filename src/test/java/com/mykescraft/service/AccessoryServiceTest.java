package com.mykescraft.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Button;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Soundcard;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.serviceimpl.AccessoryServiceImpl;

public class AccessoryServiceTest {
	
	@Autowired
	private AccessoryServiceImpl  accessoryService;
	
	@Mock
	private AccessoryRepositoryImpl accessoryRepo;
	
	@Mock
	private Hilt hilt;
	
	@Mock
	private Led led;
	
	@Mock
	private Soundcard soundcard;
	
	@Mock
	private Button button;
	
	@Mock
	private ArrayList<Led> ledList;
	
	@Mock
	private ArrayList<Hilt> hiltList;
	
	@Mock
	private ArrayList<Soundcard> soundcardList;
	
	@Mock
	private ArrayList<Button> buttonList;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		accessoryService=new AccessoryServiceImpl();
		accessoryService.setAccessoryRepo(accessoryRepo);
	}
	
	@Test
	public void shouldReturnHilt_whenFindHiltByIdIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findHiltById(5)).thenReturn(hilt);
	    // Act
	    Accessory retrievedAccessory = accessoryService.findHiltById(5);
	    // Assert
	    assertThat(retrievedAccessory, is(equalTo(hilt)));
	    verify(accessoryRepo).findHiltById(5);
	}
	
	@Test
	public void shouldReturnLed_whenFindLedByIdIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findLedById(5)).thenReturn(led);
	    // Act
	    Accessory retrievedAccessory = accessoryService.findLedById(5);
	    // Assert
	    assertThat(retrievedAccessory, is(equalTo(led)));
	    verify(accessoryRepo).findLedById(5);
	}
	
	@Test
	public void shouldReturnLedList_whenFindAllLedIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findAllLeds()).thenReturn(ledList);
	    // Act
	    ArrayList<Led> retrievedLedList = accessoryService.findAllLeds();
	    // Assert
	    assertThat(retrievedLedList, is(equalTo(ledList)));
	}
	
	@Test
	public void shouldReturnHiltList_whenFindAllHiltIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findAllHilts()).thenReturn(hiltList);
	    // Act
	    ArrayList<Hilt> retrievedHiltList = accessoryService.findAllHilts();
	    // Assert
	    assertThat(retrievedHiltList, is(equalTo(hiltList)));
	}	
	
	@Test
	public void shouldReturnSoundcard_whenFindSoundcardByIdIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findSoundcardById(8)).thenReturn(soundcard);
	    // Act
	    Accessory retrievedAccessory = accessoryService.findSoundcardById(8);
	    // Assert
	    assertThat(retrievedAccessory, is(equalTo(soundcard)));
	    verify(accessoryRepo).findSoundcardById(8);
	}
	
	@Test
	public void shouldReturnSoundcardList_whenFindAllSoundcardIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findAllSoundcards()).thenReturn(soundcardList);
	    // Act
	    ArrayList<Soundcard> retrievedSoundcardList = accessoryService.findAllSoundcards();
	    // Assert
	    assertThat(retrievedSoundcardList, is(equalTo(soundcardList)));
	}	
	
	@Test
	public void shouldReturnButton_whenFindButtonByIdIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findButtonById(11)).thenReturn(button);
	    // Act
	    Accessory retrievedAccessory = accessoryService.findButtonById(11);
	    // Assert
	    assertThat(retrievedAccessory, is(equalTo(button)));
	    verify(accessoryRepo).findButtonById(11);
	}
	
	@Test
	public void shouldReturnButtonList_whenFindAllButtonIsCalled() throws Exception {
	    // Arrange
	    when(accessoryRepo.findAllButtons()).thenReturn(buttonList);
	    // Act
	    ArrayList<Button> retrievedButtonList = accessoryService.findAllButtons();
	    // Assert
	    assertThat(retrievedButtonList, is(equalTo(buttonList)));
	}	
	
}	