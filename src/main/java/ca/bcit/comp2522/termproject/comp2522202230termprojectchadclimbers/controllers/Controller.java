package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.ChadStage;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.Level;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums.PlayerClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
  public static PlayerClass chosenPlayer;
  public static ChadStage chosenStage;
  public static Level chosenLevel;

  /**
   * Sets the default chosen values.
   */
  @FXML
  public void initialize() {
    setChosenPlayer(PlayerClass.BOY);
    setChosenLevel(Level.EASY);
    setChosenStage(ChadStage.CITY);
  }

  /**
   * Returns the chosenLevel.
   * @return chosenLevel
   */
  public static Level getChosenLevel() {
    return chosenLevel;
  }

  /**
   * Returns the chosenPlayer.
   * @return chosenPlayer
   */
  public static PlayerClass getChosenPlayer() {
    return chosenPlayer;
  }

  /**
   * Return the chosenStage.
   * @return chosenStage.
   */
  public static ChadStage getChosenStage() {
    return chosenStage;
  }

  /**
   * Sets the chosenLevel.
   * @param chosenLevel Level
   */
  public void setChosenLevel(final Level chosenLevel) {
    Controller.chosenLevel = chosenLevel;
  }

  /**
   * Sets the chosenPlayer.
   * @param chosenPlayer PlayerClass
   */
  public void setChosenPlayer(final PlayerClass chosenPlayer) {
    Controller.chosenPlayer = chosenPlayer;
  }

  /**
   * Sets the chosenStage.
   * @param chosenStage ChadStage
   */
  public void setChosenStage(final ChadStage chosenStage) {
    Controller.chosenStage = chosenStage;
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
