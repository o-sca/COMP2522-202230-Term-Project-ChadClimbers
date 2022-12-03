package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Start Controller.
 * @author Oscar
 * @version 2022
 */
public class Start extends Controller {
  @FXML
  private AnchorPane rootPane;
  @FXML
  private AnchorPane dynamicPane;
  @FXML
  private Label selectedStage;
  @FXML
  private Label selectedLevel;
  @FXML
  private Label selectedPlayer;

  /**
   * Invokes the updatedSelected method and
   * adds an EventFilter method to update whenever
   * a mouse event occurs.
   */
  @FXML
  public void initialize() {
    updateSelected();
    rootPane.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
      updateSelected();
    });
  }

  /**
   * Loads FXML file and displays a SubScene-like pane.
   * TO DO: Maybe move this method to Controller class.
   * @param fileName FXML File Name
   * @throws IOException if FXML file is not found.
   */
  private void setPane(final String fileName) throws IOException {
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource(fileName + ".fxml"));
    dynamicPane.getChildren().setAll(pane);
  }

  /**
   * Constructs a game object.
   */
  public void playButton() {
    new Game().createNewGame(
        getChosenPlayer(),
        getChosenStage(),
        getChosenLevel()
    );
  }

  /**
   * Invokes setPane method with the Player FXML file.
   * @throws IOException if FXML file is not found.
   */
  public void playerButton() throws IOException {
    setPane("Player");
  }

  /**
   * Invokes setPane method with the SelectStage FXML file.
   * @throws IOException if FXML file is not found.
   */
  public void stageButton() throws IOException {
    setPane("SelectStage");
  }

  /**
   * Invokes setPane method with the Level FXML file.
   * @throws IOException if FXML file is not found.
   */
  public void levelButton() throws IOException {
    setPane("Level");
  }

  /**
   * Updates the selected values.
   */
  private void updateSelected() {
    selectedLevel.setText(getChosenLevel().name());
    selectedPlayer.setText(getChosenPlayer().name());
    selectedStage.setText(getChosenStage().name());
  }
}