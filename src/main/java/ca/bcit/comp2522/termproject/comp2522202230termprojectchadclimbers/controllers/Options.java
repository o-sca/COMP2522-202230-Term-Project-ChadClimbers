package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.Reader;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Options Controller.
 * @author Oscar
 * @version 2022
 */
public class Options extends Controller {
  @FXML
  private Pane test;

  public void readJSON() throws FileNotFoundException, URISyntaxException {
    Reader reader = new Reader();
    reader.readJSON();
    System.out.println(reader.getSaveFileObject().saveId);
  }
}
