module ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers {
  requires javafx.controls;
  requires javafx.fxml;

  opens ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers to javafx.fxml;
  exports ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers;
  exports ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers;
  opens ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.controllers to javafx.fxml;
}