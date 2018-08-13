package com.mykescraft.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mykescraft.model.Hilt;
import com.mykescraft.model.Led;
import com.mykescraft.repositoryimpl.AccessoryRepositoryImpl;
import com.mykescraft.service.AccessoryService;

@Service
public class AccessoryServiceImpl implements AccessoryService {
	
	@Autowired
	private AccessoryRepositoryImpl accessoryRepo;

	@Override
	public List<Hilt> findAllHilts() {
		return accessoryRepo.findAllHilts();
	}

	@Override
	public List<Led> findAllLeds() {
		return accessoryRepo.findAllLeds();
	}

}
