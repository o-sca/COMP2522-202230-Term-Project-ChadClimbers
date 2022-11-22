package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
  public int currentStage = 1;
  private final int maxStage = 3;

  /**
   * Set stage to the previous stage.
   */
  public void setPrevButton() {
    if (currentStage - 1 < 1) {
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
   */
  public void displayStage() {
    Image stageImg = new Image(ChadClimbers.class.getResourceAsStream("stages/stage" + currentStage + ".png"));
    stageImage.setImage(stageImg);
    stageTitle.setText("STAGE " + currentStage);
  }
}
