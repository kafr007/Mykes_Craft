package com.mykescraft.model;

public abstract class Accessories {
  private String name;
  private double price;
  private String type;
  
  public Accessories(String name, String type, double price) {
    this.name = name;
    this.type = type;
    this.price = price;
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
