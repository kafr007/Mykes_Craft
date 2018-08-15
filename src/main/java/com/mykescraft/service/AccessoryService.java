package com.mykescraft.service;

import java.util.ArrayList;
import java.util.List;

import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;

public interface AccessoryService {
	
	ArrayList<Hilt> findAllHilts();
	
	ArrayList<Led> findAllLeds();
	
	

}
