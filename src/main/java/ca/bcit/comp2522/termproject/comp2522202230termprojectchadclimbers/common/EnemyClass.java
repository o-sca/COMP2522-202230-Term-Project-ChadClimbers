package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Builder;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Stats;

/**
 * Represents the enum class EnemyClass.
 * @author Oscar
 * @version 2022
 */
public enum EnemyClass implements EntityEnumInterface {
  GHOST(
      new Builder()
          .setUrl(ChadClimbers.class.getResource("sprites/ghost.png").toString())
          .setDefense(4)
          .setStrength(10)
          .setMaxHP(1)
          .setSpeed(10)
          .build()
  ),
  ALIEN(
      new Builder()
          .setUrl(ChadClimbers.class.getResource("sprites/alien.png").toString())
          .setDefense(4)
          .setStrength(20)
          .setMaxHP(1)
          .setSpeed(20)
          .build()
  ),
  GENGAR(
      new Builder()
          .setUrl(ChadClimbers.class.getResource("sprites/gengar.png").toString())
          .setDefense(3)
          .setStrength(30)
          .setMaxHP(5)
          .setSpeed(30)
          .build()
  ),
  SANS(
      new Builder()
          .setUrl(ChadClimbers.class.getResource("sprites/sans.png").toString())
          .setDefense(5)
          .setStrength(50)
          .setMaxHP(10)
          .setSpeed(40)
          .build()
  );

  private final Stats stats;

  /**
   * Constructs the object type EnemyClass.
   * @param stats Stats
   */
  EnemyClass(final Stats stats) {
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
