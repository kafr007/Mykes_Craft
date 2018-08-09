package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Hilt")
public class Hilt extends Accessory {
	private String imageUrl;
	
	public Hilt() {
	}

	public Hilt(String name, double price, String imageUrl) {
		super(name, price);
		this.imageUrl = imageUrl;
	}



	public String getImage() {
		return imageUrl;
	}

	public void setImage(String image) {
		this.imageUrl = image;
	}
}
