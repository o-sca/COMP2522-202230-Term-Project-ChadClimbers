package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.player;

/**
 * Builder class made to help construct the
 * Stats class to be a fluent interface.
 * @author Oscar
 * @version 2022
 */
public class Builder {
  private int maxHP;
  private int strength;
  private int defense;
  private int speed;
  private String url;

  /**
   * Sets the maxHP.
   * @param maxHP int
   * @return Builder
   */
  public Builder setMaxHP(final int maxHP) {
    this.maxHP = maxHP;
    return this;
  }

  /**
   * Sets the Strength.
   * @param strength int
   * @return Builder
   */
  public Builder setStrength(final int strength) {
    this.strength = strength;
    return this;
  }

  /**
   * Sets the Defense.
   * @param defense int
   * @return Builder
   */
  public Builder setDefense(final int defense) {
    this.defense = defense;
    return this;
  }

  /**
   * Sets the Speed.
   * @param speed int
   * @return Builder
   */
  public Builder setSpeed(final int speed) {
    this.speed = speed;
    return this;
  }

  /**
   * Sets the Url.
   * @param url String
   * @return Builder
   */
  public Builder setUrl(final String url) {
    this.url = url;
    return this;
  }

  /**
   * Construct the object type Stats with the
   * instance variables.
   * @return Stats
   */
  public Stats build() {
    return new Stats(maxHP, strength, defense, speed, url);
  }
}
