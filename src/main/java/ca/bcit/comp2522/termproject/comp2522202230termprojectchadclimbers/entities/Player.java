package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;

public enum Player {
  GIRL(ChadClimbers.class.getResource("entities/player1.gif").toString());

  private final String playerURL;

  private Player(String playerURL) {
    this.playerURL = playerURL;
  }

  public String getURL() {
    return playerURL;
  }
}