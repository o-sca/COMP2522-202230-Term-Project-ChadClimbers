package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common;

import javafx.scene.image.ImageView;

/**
 * Entity Interface.
 * @author Oscar
 * @version 2022
 */
public interface EntityInterface {
  int height = 60;
  int width = 30;

  /**
   * Construct entity.
   *
   */
  ImageView create();

  /**
   * Attack.
   */
  void attack();
}
