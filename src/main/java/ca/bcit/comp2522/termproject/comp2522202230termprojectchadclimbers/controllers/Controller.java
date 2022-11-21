package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Handles all events for the fxml files (for now).
 * @author Oscar
 * @version 2022
 */
public abstract class Controller {
  /**
   * Redirects to scene stage according to button ID.
   * @param event ActionEvent
   * @throws IOException if fxml is not found
   */
  public void button(ActionEvent event) throws IOException {
    Stage stage = loadStage(event);
    stage.show();
  }

  /**
   * Returns the fxml file as a stage.
   * @param event ActionEvent
   * @return stage
   * @throws IOException if fxml is not found
   */
  private Stage loadStage(ActionEvent event) throws IOException {
    // Parsing the button's ID to pass to the loader as the file name.
    String id = ((Node) event.getSource()).getId();

    FXMLLoader fxmlLoader = new FXMLLoader(ChadClimbers.class.getResource(id + ".fxml"));

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load());
    stage.setScene(scene);
    return stage;
  }
}
