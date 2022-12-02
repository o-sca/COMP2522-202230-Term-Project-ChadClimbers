package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.PlayerClass;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * Represents the Sprite Box class.
 * @author Oscar
 * @version 2022
 */
public class SpritePicker extends VBox {
  private ImageView circle;
  private ImageView spriteImg;

  private final String notChosen = ChadClimbers.class.getResource("circles/NotChosen.png").toString();
  private final String chosen = ChadClimbers.class.getResource("circles/Chosen.png").toString();

  private final PlayerClass playerClass;

  private boolean isChosen = false;

  /**
   * Constructs the SpritePicker object type.
   * @param playerClass PlayerClass
   */
  public SpritePicker(final PlayerClass playerClass) {
    this.playerClass = playerClass;
    createCircle();
    createPlayer();
    setAlignment(Pos.CENTER);
    setSpacing(20);
    getChildren().add(circle);
    getChildren().add(spriteImg);
  }

  /**
   * Constructs the ImageView object for circle.
   */
  private void createCircle() {
    circle = new ImageView(notChosen);
    circle.setPreserveRatio(true);
    circle.setFitHeight(20);
  }

  /**
   * Constructs the ImageView object for sprite.
   */
  private void createPlayer() {
    spriteImg = new ImageView(playerClass.getUrl());
    spriteImg.setPreserveRatio(true);
    spriteImg.setFitHeight(60);
  }

  /**
   * Returns the PlayerClass object.
   * @return playerClass
   */
  public PlayerClass getPlayer() {
    return playerClass;
  }

  /**
   * Returns the value of isChosen.
   * @return isChosen
   */
  public boolean getChosen() {
    return isChosen;
  }

  /**
   * Sets the isChosen value by the newIsChosen.
   * @param newIsChosen boolean
   */
  public void setIsChosen(final boolean newIsChosen) {
    isChosen = newIsChosen;
    String imageToSet = isChosen ? chosen : notChosen;
    circle.setImage(new Image(imageToSet));
  }
}
