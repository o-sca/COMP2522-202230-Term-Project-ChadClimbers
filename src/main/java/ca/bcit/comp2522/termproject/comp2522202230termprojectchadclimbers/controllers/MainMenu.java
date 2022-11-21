package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import javafx.application.Platform;

/**
 * Main Menu Controller.
 * @author Oscar
 * @version 2022
 */
public class MainMenu extends Controller {
  /**
   * Exit application gracefully.
   */
  public void quit() {
    Platform.exit();
    System.exit(0);
  }
}
