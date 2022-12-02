package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.EnemyClass;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.EntityInterface;
import javafx.scene.image.ImageView;

import java.util.Random;

/**
 * Represents the Enemy Class.
 * @author Oscar
 * @version 2022
 */
public class Enemy extends ImageView implements EntityInterface {
  final public int height = 60;
  final public int width = 30;

  final public ImageView enemy;

  public int maxHP;
  public int speed;
  public int strength;
  public int defense;
  public String url;

  /**
   * Construct the object type Enemy.
   * @param enemyClass EnemyClass
   */
  public Enemy(final EnemyClass enemyClass) {
    enemy = new ImageView(enemyClass.getUrl());
    enemy.setPreserveRatio(true);
    enemy.setFitWidth(width);
    enemy.setFitHeight(height);

    maxHP = enemyClass.getStats().maxHP;
    speed = enemyClass.getStats().speed;
    strength = enemyClass.getStats().strength;
    defense = enemyClass.getStats().defense;
    url = enemyClass.getStats().url;
  }

  /**
   * Create new object for Enemy.
   */
  @Override
  public ImageView create() {
    return enemy;
  }

  @Override
  public double move() {
    Random rng = new Random();

    int randInt = rng.nextInt(0,2);

    if (randInt == 0) {
      return enemy.getTranslateX() - speed;
    } else {
      return enemy.getTranslateX() + speed;
    }
  }

  @Override
  public void attack() {

  }
}
