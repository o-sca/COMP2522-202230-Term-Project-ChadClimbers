package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities.PlayerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles all events for the fxml files (for now).
 * @author Oscar
 * @version 2022
 */
public class Controller {
  public static PlayerClass chosenPlayer;
  public static Image chosenStage;
  public static int chosenLevel;

  public void setChosenStage(final Image chosenStage) {
    this.chosenStage = chosenStage;
  }

  /**
   * Redirects to scene stage according to button ID.
   * @param event ActionEvent
   * @throws IOException if fxml is not found
   */
  public Stage button(final ActionEvent event) throws IOException {
    Stage stage = loadStage(event);
    stage.show();
    return stage;
  }

  /**
   * Returns the fxml file as a stage.
   * @param event ActionEvent
   * @return stage
   * @throws IOException if fxml is not found
   */
  private Stage loadStage(final ActionEvent event) throws IOException {
    // Parsing the button's ID to pass to the loader as the file name.
    String id = ((Node) event.getSource()).getId();

    FXMLLoader fxmlLoader = new FXMLLoader(ChadClimbers.class.getResource(id + ".fxml"));

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load());
    stage.setScene(scene);
    return stage;
  }
}
