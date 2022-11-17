module ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.dyn4j;
  requires TiledReader;

  opens ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade to javafx.fxml;
  exports ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade;
}