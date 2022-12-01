package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.Level;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Represents the Level Controller class.
 * @author Oscar
 * @version 2022
 */
public class LevelController extends Controller {
  private int selectedLevel = chosenLevel.getSelectedLevel();

  @FXML
  private Label currentLevel;

  /**
   * Sets the default level.
   */
  @FXML
  public void initialize() {
    setLevel();
  }

  /**
   * Decreases the level.
   */
  public void lowerLevel() {
    if (selectedLevel - 1 < 0) return;
    selectedLevel--;
    setLevel();
  }

  /**
   * Increases the level.
   */
  public void upLevel() {
    final int maxLevel = 3;
    if (selectedLevel + 1 > maxLevel) return;
    selectedLevel++;
    setLevel();
  }

  /**
   * Changes the currentLevel FXML Label to the current selectedLevel
   * value.
   */
  private void setLevel() {
    setChosenLevel(Level.values()[selectedLevel]);
    currentLevel.setText(chosenLevel.name());
  }
}
