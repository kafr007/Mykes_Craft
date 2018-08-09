package com.mykescraft.repository;

import java.util.List;

import com.mykescraft.model.*;

public interface ProductRepository {
	
	List<Accessory> findAllProducts();
	
	Accessory findProductById(Long id);
	
}
