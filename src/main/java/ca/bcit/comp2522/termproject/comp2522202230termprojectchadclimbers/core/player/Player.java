package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.player;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.PlayerClass;
import javafx.scene.image.ImageView;

/**
 * Represents the Player Class.
 * @author Oscar
 * @version 2022
 */
public class Player extends ImageView {
  private static final int PLAYER_HEIGHT = 60;
  private static final int PLAYER_WIDTH = 30;
  private static final int ROTATE_180 = 180;

  private final ImageView player;
  private final PlayerClass playerClass;
  private final Stats stats;

  /**
   * Constructs the object type Player.
   * @param playerClass PlayerClass
   */
  public Player(final PlayerClass playerClass) {
    this.playerClass = playerClass;
    this.stats = playerClass.getStats();

    player = new ImageView(playerClass.getUrl());
    player.setFitHeight(PLAYER_HEIGHT);
    player.setFitWidth(PLAYER_WIDTH);
    player.setPreserveRatio(true);
    player.setRotate(ROTATE_180);
  }

  /**
   * Returns the ImageView object type of player.
   * @return ImageView
   */
  public ImageView toImage() {
    return player;
  }

  /**
   * Returns the moveUnits for going up.
   * @return double
   */
  public double moveUp() {
    return player.getTranslateY() - playerClass.getStats().speed;
  }

  /**
   * Returns the moveUnits for going down.
   * @return double
   */
  public double moveDown() {
    return player.getTranslateY() + playerClass.getStats().speed;
  }

  /**
   * Returns the moveUnits for going left.
   * @return double
   */
  public double moveLeft() {
    return player.getTranslateX() - playerClass.getStats().speed;
  }

  /**
   * Returns the moveUnits for going right.
   * @return double
   */
  public double moveRight() {
    return player.getTranslateX() + playerClass.getStats().speed;
  }

  /**
   * Resets the player position to the bottom of the screen..
   * @param height int
   */
  public void resetPosition(final int height) {
    player.setTranslateY(height / 2.0 - player.getBoundsInLocal().getHeight());
  }
}
