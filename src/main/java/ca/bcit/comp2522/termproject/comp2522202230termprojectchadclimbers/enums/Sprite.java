package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;

/**
 * Enum class Sprite containing the sprites existing
 * in the resource/sprites folder.
 * @author Oscar
 * @version 2022
 */
public enum Sprite {
  GIRL(ChadClimbers.class.getResource("sprites/player1.gif").toString()),
  HAT(ChadClimbers.class.getResource("sprites/player2.gif").toString()),
  JASON(ChadClimbers.class.getResource("sprites/player3.gif").toString()),
  BOY(ChadClimbers.class.getResource("sprites/player4.gif").toString()),
  TUX(ChadClimbers.class.getResource("sprites/player5.gif").toString());

  private final String spriteURL;

  /**
   * Constructs object type Sprite.
   * @param spriteURL Sprite string
   */
  Sprite(final String spriteURL) {
    this.spriteURL = spriteURL;
  }

  /**
   * Returns URL of sprite.
   * @return spriteURL string
   */
  public String getURL() {
    return spriteURL;
  }
}

