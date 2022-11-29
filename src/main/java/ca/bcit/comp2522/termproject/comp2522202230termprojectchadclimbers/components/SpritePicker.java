package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities.Sprite;
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

  private Sprite sprite;

  private boolean isChosen = false;

  /**
   * Constructs the SpritePicker object type.
   * @param newSprite Sprite
   */
  public SpritePicker(Sprite newSprite) {
    sprite = newSprite;
    createCircle();
    createSprite();
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
  private void createSprite() {
    spriteImg = new ImageView(sprite.getURL());
    spriteImg.setPreserveRatio(true);
    spriteImg.setFitHeight(60);
  }

  /**
   * Returns the sprite object.
   * @return sprite
   */
  public Sprite getSprite() {
    return sprite;
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
