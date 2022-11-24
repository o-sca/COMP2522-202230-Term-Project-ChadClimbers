package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Game Module.
 *
 * @author Oscar
 * @version 2022
 */
public class Game {
  private Pane gamePane;
  private Scene gameScene;
  private Stage gameStage;
  private Node player;
  private AnimationTimer timer;

  private boolean isUpKeyPressed;
  private boolean isDownKeyPressed;
  private boolean isRightKeyPressed;
  private boolean isLeftKeyPressed;
  private boolean isSpaceBarPressed;
  private boolean isEscKeyPressed;

  private static final int GAME_WIDTH = 600;
  private static final int GAME_HEIGHT = 400;

  /**
   * Creates a new game.
   */
  public void createNewGame() {
    player = createPlayer();
    initialiseStage();
    createKeyListener();
    createTick();
    gamePane.getChildren().add(player);
    gameStage.show();
  }

  /**
   * Constructs a player object.
   *
   * @return Node player
   */
  private Node createPlayer() {
    Rectangle rectangle = new Rectangle(40, 40, Color.GREEN);
    rectangle.setTranslateY(GAME_HEIGHT - rectangle.getHeight());
    rectangle.setTranslateX(GAME_WIDTH / 2.0);
    return rectangle;
  }

  /**
   * Initialises a Pane object to create the game stage.
   */
  private void initialiseStage() {
    gamePane = new Pane();
    gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
    gameStage = new Stage();
    gameStage.setScene(gameScene);
  }

  /**
   * Event listener for keystrokes.
   */
  private void createKeyListener() {
    gameScene.setOnKeyPressed(keyEvent -> {
      switch (keyEvent.getCode()) {
        case ESCAPE -> isEscKeyPressed = true;
        case SPACE -> isSpaceBarPressed = true;
        case LEFT -> isLeftKeyPressed = true;
        case RIGHT -> isRightKeyPressed = true;
        case UP -> isUpKeyPressed = true;
        case DOWN -> isDownKeyPressed = true;
        default -> {
        }
      }
    });
  }

  private void pause() {
    if (isEscKeyPressed) {
      isEscKeyPressed = false;
      System.out.println("Paused");
      timer.stop();
    }
  }

  /**
   * Handle events `set true` key stroke variables.
   */
  private void movePlayer() {
    if (isUpKeyPressed) {
      isUpKeyPressed = false;
      player.setTranslateY(player.getTranslateY() - 40);
    } else if (isDownKeyPressed) {
      isDownKeyPressed = false;
      player.setTranslateY(player.getTranslateY() + 40);
    } else if (isLeftKeyPressed) {
      isLeftKeyPressed = false;
      player.setTranslateX(player.getTranslateX() - 40);
    } else if (isRightKeyPressed) {
      isRightKeyPressed = false;
      player.setTranslateX(player.getTranslateX() + 40);
    } else {
      return;
    }
  }

  /**
   * Checks for all collision events.
   */
  private void checkCollision() {
    /* Boundary collision detection */
    if (player.getTranslateX() + player.getBoundsInLocal().getWidth() > GAME_WIDTH) {
      player.setTranslateX(player.getTranslateX() - 40);
    } else if (player.getTranslateX() < 0) {
      player.setTranslateX(player.getTranslateX() + 40);
    } else if (player.getTranslateY() + player.getBoundsInLocal().getHeight() > GAME_HEIGHT) {
      player.setTranslateY(player.getTranslateY() - 40);
    }
    /* Reach the top, you win! */
    if (player.getTranslateY() < 0) {
      player.setTranslateY(0);
      System.out.println("Win");
      /* Temp exit strategy xD */
      gameStage.close();
    }
  }

  /**
   * Starts interval timer for recurring method calls.
   */
  private void createTick() {
    timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        movePlayer();
        checkCollision();
        pause();
      }
    };
    timer.start();
  }
}