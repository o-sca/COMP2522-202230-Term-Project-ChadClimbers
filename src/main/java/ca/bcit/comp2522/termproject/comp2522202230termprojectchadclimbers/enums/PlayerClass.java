package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.player.Builder;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.player.Stats;

/**
 * Represents the PlayerClass Enum Class.
 * @author Oscar
 * @version 2022
 */
public enum PlayerClass {
  JASON(
    new Builder()
      .setUrl(Sprite.JASON.getURL())
      .setDefense(100)
      .setStrength(100)
      .setMaxHP(100)
      .setSpeed(100)
      .build()
  ),
  GIRL(
    new Builder()
      .setUrl(Sprite.GIRL.getURL())
      .setDefense(10)
      .setStrength(3)
      .setMaxHP(5)
      .setSpeed(30)
      .build()
  ),
  HAT(
     new Builder()
      .setUrl(Sprite.HAT.getURL())
      .setDefense(20)
      .setStrength(15)
      .setMaxHP(3)
      .setSpeed(30)
      .build()
  ),
  BOY(
    new Builder()
      .setUrl(Sprite.BOY.getURL())
      .setDefense(40)
      .setStrength(25)
      .setMaxHP(5)
      .setSpeed(20)
      .build()
  ),
  TUX(
     new Builder()
      .setUrl(Sprite.BOY.getURL())
      .setDefense(10)
      .setStrength(35)
      .setMaxHP(4)
      .setSpeed(40)
      .build()
  );


  private final Stats stats;

  /**
   * Constructs the object type PlayerClass.
   * @param stats Stats
   */
  PlayerClass(final Stats stats) {
    this.stats = stats;
  }

  /**
   * Returns the stats of the PlayerClass.
   * @return Stats
   */
  public Stats getStats() {
    return stats;
  }

  /**
   * Returns the PlayerClass Url.
   * @return String
   */
  public String getUrl() {
    return stats.url;
  }
}
