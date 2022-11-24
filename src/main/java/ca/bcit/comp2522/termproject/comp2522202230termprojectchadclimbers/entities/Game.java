package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game {
  private Pane gamePane;
  private Scene gameScene;
  private Stage gameStage;
  private Node player;

  private static final int GAME_WIDTH = 600;
  private static final int GAME_HEIGHT = 400;

  public void createNewGame() {
      player = createPlayer();
      initialiseStage();
      createKeyListener();
      gamePane.getChildren().add(player);
      gameStage.show();
  }

  private Node createPlayer() {
    Rectangle rectangle = new Rectangle(30, 30, Color.GREEN);
    rectangle.setY(GAME_HEIGHT - 50);
    rectangle.setX(GAME_WIDTH/2.0);
    return rectangle;
  }

  private void initialiseStage() {
    gamePane = new Pane();
    gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
    gameStage = new Stage();
    gameStage.setScene(gameScene);
  }

  private void createKeyListener() {
    gameScene.setOnKeyPressed(keyEvent -> {
      switch (keyEvent.getCode()) {
        case ESCAPE -> {/* Create some sort of pause screen here */}
        case LEFT-> player.setTranslateX(player.getTranslateX() - 40);
        case RIGHT -> player.setTranslateX(player.getTranslateX() + 40);
        case UP -> player.setTranslateY(player.getTranslateY() - 40);
        case DOWN -> player.setTranslateY(player.getTranslateY() + 40);
        default -> {
        }
      }
    });
  }
}