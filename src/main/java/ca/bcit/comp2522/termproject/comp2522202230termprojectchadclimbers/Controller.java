package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers;

import javafx.application.Platform;
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
public class Controller {
  /**
   * Redirects scene to Select Stage.
   * @param event ActionEvent
   * @throws IOException if fxml is not found
   */
  public void startButton(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SelectStage.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load());
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Redirects scene to Leaderboard.
   * @param event ActionEvent
   * @throws IOException if fxml is not found
   */
  public void leaderboardButton(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Leaderboard.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load());
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Redirects scene to Options.
   * @param event ActionEvent
   * @throws IOException if fxml is not found
   */
  public void optionsButton(ActionEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Options.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(fxmlLoader.load());
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Exit application gracefully.
   */
  public void quitButton() {
    Platform.exit();
    System.exit(0);
  }
}
