package com.mykescraft.service;

import java.util.ArrayList;
import java.util.List;

import com.mykescraft.model.Blade;
import com.mykescraft.model.Button;
import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Soundcard;

public interface AccessoryService {
	
	ArrayList<Hilt> findAllHilts();
	
	ArrayList<Led> findAllLeds();
	
	ArrayList<Soundcard> findAllSoundcards();
	
	ArrayList<Button> findAllButtons();
	
	ArrayList<Blade> findAllBlades();
	
	Hilt findHiltById(long id);
	
	Led findLedById(long id);
	
	Soundcard findSoundcardById(long id);

	Button findButtonById(long id);
	
	Blade findBladeById(long id);
	
}
