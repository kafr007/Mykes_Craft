package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Button")
public class Button extends Accessory {
	
	 public Button() {   
	  }

}
