package com.mykescraft.repository;

import java.util.List;

import com.mykescraft.model.*;

public interface AccessoryRepository {
	
	List<Accessory> findAllProducts();
	
	Accessory findAccessoryById(Long id);
	
	List<Blade> findAllBlades();
	
	List<Button> findAllButtons();
	
	List<Hilt> findAllHilts();
	
	List<Led> findAllLeds();
	
	List<Soundcard> findAllSoundcards();
	
	
	
	
}
