package com.mykescraft.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.mykescraft.model.Accessory;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
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
	private ArrayList<Led> ledList;
	
	@Mock
	private ArrayList<Hilt> hiltList;
	
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
	
}	