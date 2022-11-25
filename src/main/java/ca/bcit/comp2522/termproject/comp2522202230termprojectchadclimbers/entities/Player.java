package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;

public enum Player {
  GIRL(ChadClimbers.class.getResource("entities/player1.gif").toString()),
  HAT(ChadClimbers.class.getResource("entities/player2.gif").toString()),
  BALD(ChadClimbers.class.getResource("entities/player3.gif").toString()),
  BOY(ChadClimbers.class.getResource("entities/player4.gif").toString()),
  TUX(ChadClimbers.class.getResource("entities/player5.gif").toString());

  private final String playerURL;

  private Player(String playerURL) {
    this.playerURL = playerURL;
  }

  public String getURL() {
    return playerURL;
  }
}