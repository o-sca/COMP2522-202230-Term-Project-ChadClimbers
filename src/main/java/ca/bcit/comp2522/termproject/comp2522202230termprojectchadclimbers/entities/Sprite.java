package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;

public enum Sprite {
  GIRL(ChadClimbers.class.getResource("sprites/player1.gif").toString()),
  HAT(ChadClimbers.class.getResource("sprites/player2.gif").toString()),
  JASON(ChadClimbers.class.getResource("sprites/player3.gif").toString()),
  BOY(ChadClimbers.class.getResource("sprites/player4.gif").toString()),
  TUX(ChadClimbers.class.getResource("sprites/player5.gif").toString());

  private final String spriteURL;

  Sprite(String spriteURL) {
    this.spriteURL = spriteURL;
  }

  public String getURL() {
    return spriteURL;
  }
}

