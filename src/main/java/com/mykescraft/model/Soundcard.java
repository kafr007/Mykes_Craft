package com.mykescraft.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Soundcard")
public class Soundcard extends Accessory {

	public Soundcard() {
	}


}
