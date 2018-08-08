package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Hilt")
public class Hilt extends Product {
	private String imageUrl;
	
	public Hilt() {
	}

	public Hilt(String name, String type, double price, String imageUrl) {
		super(name, type, price);
		this.imageUrl = imageUrl;
	}
	
	public Hilt(String name, String type, double price) {
		super(name, type, price);
	}



	public String getImage() {
		return imageUrl;
	}

	public void setImage(String image) {
		this.imageUrl = image;
	}
}
