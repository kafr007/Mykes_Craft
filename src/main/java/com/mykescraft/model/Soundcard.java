package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Soundcard")
public class Soundcard extends Product {

	public Soundcard() {
	}

	public Soundcard(String name, String type, double price) {
		super(name, type, price);
	}


}
