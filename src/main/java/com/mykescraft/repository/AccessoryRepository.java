package com.mykescraft.repository;

import java.util.List;

import com.mykescraft.model.*;

public interface AccessoryRepository {
	
	Blade findBladeById(Long id);
	
	Button findButtonById(Long id);
	
	Hilt findHiltById(Long id);
	
	Led findLedById(Long id);
	
	Soundcard findSOundcardById(Long id);
	
	List<Blade> findAllBlades();
	
	List<Button> findAllButtons();
	
	List<Hilt> findAllHilts();
	
	List<Led> findAllLeds();
	
	List<Soundcard> findAllSoundcards();
	
	
	
	
}
