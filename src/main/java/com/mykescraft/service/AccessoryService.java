package com.mykescraft.service;

import java.util.List;

import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;

public interface AccessoryService {
	
	List<Hilt> findAllHilts();
	
	List<Led> findAllLeds();
	
	

}
