package com.mykescraft.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Blade")
public class Blade extends Product {
	@Column
	private double length;
	@Column
	private String wallThickness;
	@Column
	private String tip;

	public Blade() {
	}

	public Blade(String name, String type, double length, String wallThickness, String tip, double price) {
		super(name, type, price);
		this.length = length;
		this.wallThickness = wallThickness;
		this.tip = tip;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getWallThickness() {
		return wallThickness;
	}

	public void setWallThickness(String wallThickness) {
		this.wallThickness = wallThickness;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}
