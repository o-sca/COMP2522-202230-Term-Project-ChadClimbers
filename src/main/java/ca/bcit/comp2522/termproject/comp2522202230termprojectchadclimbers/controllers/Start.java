package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

  /**
   * Loads FXML file and displays a subscene-like pane.
   * TO DO: Maybe move this method to Controller class.
   * @param fileName FXML File Name
   * @throws IOException if FXML file is not found.
   */
  private void setPane(String fileName) throws IOException {
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource(fileName + ".fxml"));
    rootPane.getChildren().setAll(pane);
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
  public void levelButton() throws IOException{
    setPane("Level");
  }
}