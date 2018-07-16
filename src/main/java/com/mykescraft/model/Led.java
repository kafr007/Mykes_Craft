package com.mykescraft.model;

public class Led extends Accessories {
      private String color;

      public Led(String name, String type, String color, double price) {
        super(name, type, price);
        this.color = color;
      }

      public String getColor() {
        return color;
      }

      public void setColor(String color) {
        this.color = color;
      }
      
      
}
