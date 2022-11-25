package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Creates a pause pop screen pane.
 * @author Oscar
 * @version 2022
 */
public class Pause extends StackPane {
  private final StackPane pausePane;
  private final int WIDTH = 400;
  private final int HEIGHT = 200;

  /**
   * Constructs the pause object type.
   */
  public Pause() {
    pausePane = new StackPane();
    Text pauseText = new Text("Paused");
    pauseText.setFill(Color.BLACK);
    pausePane.setStyle("-fx-background-color: white");
    pausePane.setLayoutX(WIDTH);
    pausePane.setLayoutY(HEIGHT);
    pausePane.getChildren().add(pauseText);
    setAlignment(pauseText, Pos.TOP_CENTER);
  }

  /**
   * Returns the StackPane type object Pause.
   * @return StackPane pause
   */
  public StackPane getPausePane() {
    return pausePane;
  }
}
