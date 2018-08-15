package com.mykescraft.repository;

import java.util.ArrayList;
import java.util.List;

import com.mykescraft.model.*;

public interface AccessoryRepository {
	
	Blade findBladeById(int id);
	
	Button findButtonById(int id);
	
	Hilt findHiltById(int id);
	
	Led findLedById(int id);
	
	Soundcard findSOundcardById(int id);
	
	ArrayList<Blade> findAllBlades();
	
	ArrayList<Button> findAllButtons();
	
	ArrayList<Hilt> findAllHilts();
	
	ArrayList<Led> findAllLeds();
	
	ArrayList<Soundcard> findAllSoundcards();
	
	
	
	
}
