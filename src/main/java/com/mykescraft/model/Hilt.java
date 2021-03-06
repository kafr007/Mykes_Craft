package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Hilt")
public class Hilt extends Accessory {
		
	public Hilt() {
	}

	public Hilt(long id, String name, double price, String imageUrl) {
		super(id, name, price,imageUrl);
		}
	
	public Hilt(String name, double price, String imageUrl) {
		super(name, price,imageUrl);
		}
}
