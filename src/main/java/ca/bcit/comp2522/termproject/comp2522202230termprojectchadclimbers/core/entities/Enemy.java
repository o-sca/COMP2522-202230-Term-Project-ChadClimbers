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
  final private ImageView enemy;
  final public Stats stats;


  /**
   * Construct the object type Enemy.
   * @param enemyClass EnemyClass
   */
  public Enemy(final EnemyClass enemyClass) {
    enemy = new ImageView(enemyClass.getUrl());
    enemy.setPreserveRatio(true);
    enemy.setFitWidth(width);
    enemy.setFitHeight(height);

    stats = enemyClass.getStats();
  }

  /**
   * Create new object for Enemy.
   */
  @Override
  public ImageView create() {
    return enemy;
  }

  /**
   * Move enemy entity randomly left or right.
   * @return move unit Double
   */
  public double move() {
    Random rng = new Random();

    int randInt = rng.nextInt(0,2);

    if (randInt == 0) {
      return enemy.getTranslateX() - stats.speed;
    } else {
      return enemy.getTranslateX() + stats.speed;
    }
  }

  @Override
  public void attack() {

  }
}
