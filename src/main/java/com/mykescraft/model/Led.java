package com.mykescraft.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("Led")
public class Led extends Accessory {
	
	@Column
	private String color;

	public Led() {
		
	}
	
	public Led(String name, double price, String imageUrl, String color) {
		super(name, price, imageUrl);
		this.color = color;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
