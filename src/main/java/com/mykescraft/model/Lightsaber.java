package com.mykescraft.model;

public class Lightsaber {
  private Hilt hilt;
  private Led led;
  private Soundcard soundCard;
  private Button button;
  private Blade blade;
  
  /*Contstructor for lightsaber with a blade*/
  public Lightsaber(Hilt hilt, Led led, Soundcard soundCard, Button button, Blade blade) {
    this.hilt = hilt;
    this.led = led;
    this.soundCard = soundCard;
    this.button = button;
    this.blade = blade;
  }

  /*Contstructor for lightsaber without blade*/
  public Lightsaber(Hilt hilt, Led led, Soundcard soundCard, Button button) {
    this.hilt = hilt;
    this.led = led;
    this.soundCard = soundCard;
    this.button = button;
  }

  public Hilt getHilt() {
    return hilt;
  }

  public void setHilt(Hilt hilt) {
    this.hilt = hilt;
  }

  public Led getLed() {
    return led;
  }

  public void setLed(Led led) {
    this.led = led;
  }

  public Soundcard getSoundCard() {
    return soundCard;
  }

  public void setSoundCard(Soundcard soundCard) {
    this.soundCard = soundCard;
  }

  public Button getButton() {
    return button;
  }

  public void setButton(Button button) {
    this.button = button;
  }

  public Blade getBlade() {
    return blade;
  }

  public void setBlade(Blade blade) {
    this.blade = blade;
  }
  
  
  
  
  
  
  
  
  
  
  

}
