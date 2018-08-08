package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Button")
public class Button extends Product {
	
	 public Button() {   
	  }
  
  public Button(String name, String type, double price) {
    super(name, type, price);
  }

}
