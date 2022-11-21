package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class for game.
 * @author Oscar
 * @version 2022
 */
public class ChadClimbers extends Application {
  /**
   * Base start method.
   *
   * @param stage stage
   * @throws Exception if any exceptions occur
   */
  @Override
  public void start(Stage stage) throws Exception {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
    Scene scene = new Scene(fxmlLoader.load());

    stage.setTitle("Chad Climbers");
    stage.setResizable(false);
    stage.setScene(scene);

    stage.show();
  }

  /**
   * Driver of the program.
   * @param args unused
   */
  public static void main(String[] args) {
    launch();
  }
}
