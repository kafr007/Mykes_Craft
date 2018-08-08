package com.mykescraft.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name= "Product_Type")
public abstract class Product {
	
	@GeneratedValue
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	private Order order;
	
	@Column
	private double price;
	
	@Column
	private String type;
	
	public Product() {
	}

	public Product(Product product) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public Product(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
