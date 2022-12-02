package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Builder;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Stats;

/**
 * Represents the PlayerClass Enum Class.
 * @author Oscar
 * @version 2022
 */
public enum PlayerClass implements EntityEnumInterface {
  JASON(
    new Builder()
      .setUrl(ChadClimbers.class.getResource("sprites/player3.gif").toString())
      .setDefense(100)
      .setStrength(100)
      .setMaxHP(100)
      .setSpeed(100)
      .build()
  ),
  GIRL(
    new Builder()
      .setUrl(ChadClimbers.class.getResource("sprites/player1.gif").toString())
      .setDefense(10)
      .setStrength(3)
      .setMaxHP(80)
      .setSpeed(30)
      .build()
  ),
  HAT(
     new Builder()
      .setUrl(ChadClimbers.class.getResource("sprites/player2.gif").toString())
      .setDefense(20)
      .setStrength(15)
      .setMaxHP(70)
      .setSpeed(30)
      .build()
  ),
  BOY(
    new Builder()
      .setUrl(ChadClimbers.class.getResource("sprites/player4.gif").toString())
      .setDefense(40)
      .setStrength(25)
      .setMaxHP(60)
      .setSpeed(20)
      .build()
  ),
  TUX(
     new Builder()
      .setUrl(ChadClimbers.class.getResource("sprites/player5.gif").toString())
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

  @Override
  public Stats getStats() {
    return stats;
  }

  @Override
  public String getUrl() {
    return stats.url;
  }


}
