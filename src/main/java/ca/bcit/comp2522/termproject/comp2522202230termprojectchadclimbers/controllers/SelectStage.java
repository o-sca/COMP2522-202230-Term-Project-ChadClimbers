package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.ChadStage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * Select Stage Controller.
 * @author Oscar
 * @version 2022
 */
public class SelectStage extends Controller {
  @FXML
  private ImageView stageImage;
  @FXML
  private Label stageTitle;

  private int currentStage = 0;
  private final int maxStage = 2;

  /**
   * Sets the initial stage display.
   */
  @FXML
  public void initialize() {
    currentStage = 0;
    displayStage();
  }

  /**
   * Set stage to the previous stage.
   */
  public void setPrevButton() {
    if (currentStage - 1 < 0) {
      return;
    } else {
      currentStage--;
    }
    displayStage();
  }

  /**
   * Set stage to the next stage.
   */
  public void setNextButton() {
    if (currentStage + 1 > maxStage) {
      return;
    } else {
      currentStage++;
    }
   displayStage();
  }

  /**
   * Displays the current stage image and title.
   * Sets the instance variable chosenStage.
   */
  public void displayStage() {
    chosenStage = ChadStage.values()[currentStage];
    stageImage.setImage(chosenStage.getImage());
    stageTitle.setText(chosenStage.name());
  }
}
