package com.mykescraft.model;

public class Hilt extends Product {
	private byte[] image;

	public Hilt(String name, String type, double price, byte[] image) {
		super(name, type, price);
		this.image = image;
	}
	
	public Hilt(String name, String type, double price) {
		super(name, type, price);
	}



	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
