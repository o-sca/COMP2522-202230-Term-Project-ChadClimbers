package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.player;

/**
 * Represents the Stats Class.
 * @author Oscar
 * @version 2022
 */
public class Stats {
  public int maxHP;
  public int strength;
  public int defense;
  public int speed;
  public String url;

  /**
   * Constructs the object type Stats.
   * @param maxHP     int
   * @param strength  int
   * @param defense   int
   * @param speed     int
   * @param url       String
   */
  public Stats(
    final int maxHP,
    final int strength,
    final int defense,
    final int speed,
    final String url
  ) {
    this.maxHP = maxHP;
    this.strength = strength;
    this.defense = defense;
    this.speed = speed;
    this.url = url;
  }
}
