package com.mykescraft.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Led")
public class Led extends Accessory {

	@Column
	private String color;

	public Led() {
	}

	public Led(String name, String color, double price) {
		super(name, price);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
