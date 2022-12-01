package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.SpritePicker;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.PlayerClass;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.Sprite;
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

  @FXML
  private Pane playerPane;
  @FXML
  private Label playerName;
  @FXML
  private Label playerHP;
  @FXML
  private Label playerStrength;
  @FXML
  private Label playerDefense;
  @FXML
  private Label playerSpeed;


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
    final int boxSpace = 40;

    HBox box = new HBox();
    box.setSpacing(boxSpace);

    for (Sprite sprite : Sprite.values()) {
      SpritePicker spriteToPick = new SpritePicker(sprite);
      sprites.add(spriteToPick);
      box.getChildren().add(spriteToPick);

      spriteToPick.setOnMouseClicked(mouseEvent -> {
        for (SpritePicker spritePicker : sprites) {
          spritePicker.setIsChosen(false);
        }

        spriteToPick.setIsChosen(true);
        displayPlayerStats(spriteToPick);
      });
    }
    return box;
  }

  /**
   * Displays each player class stats onto the pane.
   * @param spriteToPick SpritePicker
   */
  private void displayPlayerStats(final SpritePicker spriteToPick) {
    final PlayerClass playerClass = PlayerClass.valueOf(spriteToPick.getSprite().name());
    playerName.setText(spriteToPick.getSprite().name());
    playerHP.setText(String.valueOf(playerClass.getStats().maxHP));
    playerDefense.setText(String.valueOf(playerClass.getStats().defense));
    playerStrength.setText(String.valueOf(playerClass.getStats().strength));
    playerSpeed.setText(String.valueOf(playerClass.getStats().speed));
    chosenPlayer = PlayerClass.valueOf(spriteToPick.getSprite().name());
  }
}