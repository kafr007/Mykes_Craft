package com.mykescraft.model;

public class Blade extends Accessories {
  private double length;
  private double wallThickness;
  private String tip;
  
  public Blade(String name, String type, double length, double wallThickness, String tip, double price) {
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

  public double getWallThickness() {
    return wallThickness;
  }

  public void setWallThickness(double wallThickness) {
    this.wallThickness = wallThickness;
  }

  public String getTip() {
    return tip;
  }

  public void setTip(String tip) {
    this.tip = tip;
  }
  
  
}
