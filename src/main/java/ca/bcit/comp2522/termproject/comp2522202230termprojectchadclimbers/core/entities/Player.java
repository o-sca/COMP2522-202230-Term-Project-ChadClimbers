package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.EntityInterface;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.PlayerClass;
import javafx.scene.image.ImageView;

/**
 * Represents the Player Class.
 * @author Oscar
 * @version 2022
 */
public class Player extends ImageView implements EntityInterface {
  private final ImageView player;
  private final Stats stats;

  /**
   * Constructs the object type Player.
   * @param playerClass PlayerClass
   */
  public Player(final PlayerClass playerClass) {
    this.stats = playerClass.getStats();

    player = new ImageView(playerClass.getUrl());
    player.setFitHeight(height);
    player.setFitWidth(width);
    player.setPreserveRatio(true);
    player.setRotate(180);
  }

  /**
   * Returns the ImageView object type of player.
   * @return ImageView
   */
  public ImageView create() {
    return player;
  }

  /**
   * Returns the moveUnits for going up.
   * @return double
   */
  public double moveUp() {
    return player.getTranslateY() - stats.speed;
  }

  /**
   * Returns the moveUnits for going down.
   * @return double
   */
  public double moveDown() {
    return player.getTranslateY() + stats.speed;
  }

  /**
   * Returns the moveUnits for going left.
   * @return double
   */
  public double moveLeft() {
    return player.getTranslateX() - stats.speed;
  }

  /**
   * Returns the moveUnits for going right.
   * @return double
   */
  public double moveRight() {
    return player.getTranslateX() + stats.speed;
  }

  /**
   * Resets the player position to the bottom of the screen..
   * @param height int
   */
  public void resetPosition(final int height) {
    player.setTranslateY(height / 2.0 - player.getBoundsInLocal().getHeight());
  }

  @Override
  public void attack() {

  }
}
