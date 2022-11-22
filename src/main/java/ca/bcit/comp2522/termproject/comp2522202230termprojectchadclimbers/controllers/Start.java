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

  public void playerButton(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource("Player.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  public void shopButton(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource("Shop.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  public void stageButton(ActionEvent event) throws IOException {
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource("SelectStage.fxml"));
    rootPane.getChildren().setAll(pane);
  }

  public void levelButton(ActionEvent event) throws IOException{
    AnchorPane pane = FXMLLoader.load(ChadClimbers.class.getResource("Level.fxml"));
    rootPane.getChildren().setAll(pane);
  }
}