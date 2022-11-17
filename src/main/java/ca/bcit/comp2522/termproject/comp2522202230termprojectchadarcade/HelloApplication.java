package ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.dyn4j.world.World;
import org.tiledreader.FileSystemTiledReader;
import org.tiledreader.TiledMap;
import org.tiledreader.TiledReader;

import java.io.IOException;


public class HelloApplication extends Application {

  TiledReader tileFile = new FileSystemTiledReader();


  private Platformer character;
  @Override
  public void start(Stage stage) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
    TiledMap tiledMap = tileFile.getMap(HelloApplication.class.getResource("/collision.tmx").getPath());
    Rectangle character = new Rectangle();
    character.setHeight(20.0);
    character.setWidth(20.0);
    Group someGroup = new Group();
    someGroup.getChildren().add(character);
    Scene scene = new Scene(someGroup);
    stage.setTitle("HEllo !");
    stage.setScene(scene);
    stage.setHeight(500);
    stage.setWidth(500);
    stage.show();
  }
//  public void processKeyPress(final KeyEvent event){
//
//    switch (event.getCode()){
//      case UP -> character.setY(character);
//    }
//  }


  public static void main(String[] args) {
    launch();
  }
}