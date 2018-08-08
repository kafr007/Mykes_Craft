package com.mykescraft.repositoryimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mykescraft.model.Product;
import com.mykescraft.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById() {
		// TODO Auto-generated method stub
		return null;
	}

}
