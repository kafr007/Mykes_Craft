package com.mykescraft.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.model.Soundcard;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.service.AccessoryService;

@Service
public class AccessoryServiceImpl implements AccessoryService {
	
	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	@Override
	public ArrayList<Hilt> findAllHilts() {
		return accessoryRepo.findAllHilts();
	}

	@Override
	public ArrayList<Led> findAllLeds() {
		return accessoryRepo.findAllLeds();
	}
	
	@Override
	public ArrayList<Soundcard> findAllSoundcards(){
		return accessoryRepo.findAllSoundcards();
	}
	
	@Override
	public Soundcard findSoundcardById(long id) {
		return accessoryRepo.findSoundcardById(id);
	}
	
	public Hilt findHiltById(long id) {
		return accessoryRepo.findHiltById(id);
	}
	
	public Led findLedById(long id) {
		return accessoryRepo.findLedById(id);
	}

	public AccessoryRepositoryImpl getAccessoryRepo() {
		return accessoryRepo;
	}

	public void setAccessoryRepo(AccessoryRepositoryImpl accessoryRepo) {
		this.accessoryRepo = accessoryRepo;
	}
	
}
