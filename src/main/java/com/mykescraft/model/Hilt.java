package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Hilt")
public class Hilt extends Accessory {
		
	public Hilt() {
	}

	public Hilt(String name, double price) {
		super(name, price);
		}
}
