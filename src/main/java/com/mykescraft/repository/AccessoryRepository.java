package com.mykescraft.repository;

import java.util.ArrayList;
import java.util.List;

import com.mykescraft.model.*;

public interface AccessoryRepository {
	
	Blade findBladeById(long id);
	
	Button findButtonById(long id);
	
	Hilt findHiltById(long id);
	
	Led findLedById(long id);
	
	Soundcard findSoundcardById(long id);
	
	ArrayList<Blade> findAllBlades();
	
	ArrayList<Button> findAllButtons();
	
	ArrayList<Hilt> findAllHilts();
	
	ArrayList<Led> findAllLeds();
	
	ArrayList<Soundcard> findAllSoundcards();
	
	
	
	
}
