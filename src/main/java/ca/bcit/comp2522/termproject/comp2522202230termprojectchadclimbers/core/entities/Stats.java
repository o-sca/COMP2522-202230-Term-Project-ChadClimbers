package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities;

/**
 * Represents the Stats Class.
 * @author Oscar
 * @version 2022
 */
public class Stats {
  public int currentHP;
  public int maxHP;
  public int strength;
  public int defense;
  public int speed;
  public String url;

  /**
   * Constructs the object type Stats.
   * @param currentHP int
   * @param maxHP     int
   * @param strength  int
   * @param defense   int
   * @param speed     int
   * @param url       String
   */
  public Stats(
    final int currentHP,
    final int maxHP,
    final int strength,
    final int defense,
    final int speed,
    final String url
  ) {
    this.currentHP = currentHP;
    this.maxHP = maxHP;
    this.strength = strength;
    this.defense = defense;
    this.speed = speed;
    this.url = url;
  }
}
