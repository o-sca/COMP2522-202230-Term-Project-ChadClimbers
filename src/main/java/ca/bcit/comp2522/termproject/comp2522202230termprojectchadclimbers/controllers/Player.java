package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.SpritePicker;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities.Sprite;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * Player Controller class.
 * @author Oscar
 * @version 2022
 */
public class Player extends Controller {
  private final ArrayList<SpritePicker> sprites = new ArrayList<>();
  private Sprite chosenSprite;

  @FXML
  private Pane playerPane;
  @FXML
  private Label playerName;

  /**
   * Replacement for Constructor to perform all post-processing on
   * any content.
   * Invokes the createSpriteToChoose() to load all the existing
   * sprites from the enum class Sprite.
   */
  @FXML
  public void initialize() {
    playerPane.getChildren().add(createSpriteToChoose());

  }

  /**
   * Iterates through the Sprite enum class and creates a new
   * SpritePicker object passing the Sprite into it.
   * @return HBox
   */
  private HBox createSpriteToChoose() {
    HBox box = new HBox();
    box.setSpacing(40);

    for (Sprite sprite : Sprite.values()) {
      SpritePicker spriteToPick = new SpritePicker(sprite);
      sprites.add(spriteToPick);
      box.getChildren().add(spriteToPick);

      spriteToPick.setOnMouseClicked(mouseEvent -> {
        for (SpritePicker spritePicker : sprites) {
          spritePicker.setIsChosen(false);
        }

        spriteToPick.setIsChosen(true);
        playerName.setText(spriteToPick.getSprite().name());
        chosenSprite = spriteToPick.getSprite();
      });
    }

    return box;
  }
}