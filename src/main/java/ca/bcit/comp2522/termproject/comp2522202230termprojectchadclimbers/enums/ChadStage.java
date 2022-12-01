package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import javafx.scene.image.Image;

/**
 * Enum class for the stages.
 * @author Oscar
 * @version 2022
 */
public enum ChadStage {
  CITY(ChadClimbers.class.getResource("stages/city.png").toString()),
  MEADOW(ChadClimbers.class.getResource("stages/meadow.png").toString()),
  RUINS(ChadClimbers.class.getResource("stages/ruins.png").toString());

  private final String chadStageURL;

  /**
   * Constructs the object type ChadStage.
   * @param chadStageURL String
   */
  ChadStage(final String chadStageURL) {
    this.chadStageURL = chadStageURL;
  }

  /**
   * Returns the stage as an Image object.
   * @return Image object stage
   */
  public Image getImage() {
    return new Image(chadStageURL);
  }
}
