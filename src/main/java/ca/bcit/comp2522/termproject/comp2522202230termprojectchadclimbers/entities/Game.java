package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.Pause;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Game Module.
 *
 * @author Oscar && Atsuki
 * @version 2022
 */
public class Game {
  private ImageView player;
  private GridPane gamePane;
  private Scene gameScene;
  private Stage gameStage;
  private StackPane pausePane;
  private boolean isUpKeyPressed;
  private boolean isDownKeyPressed;
  private boolean isRightKeyPressed;
  private boolean isLeftKeyPressed;
  private boolean isSpaceBarPressed;
  private boolean isEscKeyPressed;
  private boolean paused;
  private boolean pausedPanePoppedUp;
  private static final int GAME_WIDTH = 600;
  private static final int GAME_HEIGHT = 400;

  /**
   * Instantiate a new game.
   */
  public void createNewGame() {
    initialiseStage();
    createPlayer(Player.BALD);
    createKeyListener();
    createTick();
    gameStage.show();
  }

  /**
   * Constructs a player object.
   */
  private void createPlayer(Player chosenPlayer) {
    player = new ImageView(chosenPlayer.getURL());
    player.setFitHeight(60);
    player.setFitWidth(30);
    player.setPreserveRatio(true);
    player.setTranslateY(GAME_HEIGHT);
    gamePane.getChildren().add(player);
  }


  /**
   * Initialises a Pane object to create the game stage.
   */
  private void initialiseStage() {
    gamePane = new GridPane();
    gamePane.setAlignment(Pos.CENTER);
    gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
    Image img = new Image(ChadClimbers.class.getResourceAsStream("stages/stage1.png"));
    gamePane.setBackground(new Background(new BackgroundImage(
            img,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            BackgroundSize.DEFAULT
    )));
    gameStage = new Stage();
    gameStage.setScene(gameScene);
  }

  /**
   * Event listener for keystrokes.
   */
  private void createKeyListener() {
    gameScene.setOnKeyPressed(keyEvent -> {
      /* If paused and keyEvent is not Escape -> return else go to switch case. */
      if (paused && keyEvent.getCode() != KeyCode.ESCAPE) return;
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

  /**
   * Toggles paused variable.
   */
  private void pause() {
    if (isEscKeyPressed) {
      paused = !paused;
      isEscKeyPressed = false;
    }
  }


  /**
   * Constructs the Pause popup Stack pane.
   */
  private void createPausePopup() {
    if (!pausedPanePoppedUp && paused) {
      pausedPanePoppedUp = true;
      pausePane = new Pause().getPausePane();
      gamePane.getChildren().add(pausePane);
    } else if (pausedPanePoppedUp && !paused) {
      pausedPanePoppedUp = false;
      gamePane.getChildren().remove(pausePane);
    }
  }

  /**
   * Handle events `set true` key stroke variables.
   */
  private void movePlayer() {
    if (isUpKeyPressed) {
      isUpKeyPressed = false;
      player.setTranslateY(player.getTranslateY() - 20);
      player.setRotate(180);
    } else if (isDownKeyPressed) {
      isDownKeyPressed = false;
      player.setTranslateY(player.getTranslateY() + 20);
      player.setRotate(360);
    } else if (isLeftKeyPressed) {
      isLeftKeyPressed = false;
      player.setTranslateX(player.getTranslateX() - 20);
      player.setRotate(90);
    } else if (isRightKeyPressed) {
      isRightKeyPressed = false;
      player.setTranslateX(player.getTranslateX() + 20);
      player.setRotate(-90);
    } else {
      return;
    }
  }


  /**
   * Checks for all collision events.
   */
  private void checkCollision() {
    final double playerY = player.getTranslateY() + player.getBoundsInLocal().getCenterY();
    final double playerX = player.getTranslateX();
    /* Boundary collision detection */
    /* When playerX reaches left side of the screen. */
    if (playerX >= GAME_WIDTH/2.0) {
      player.setTranslateX(player.getTranslateX() - 20);
    }
    /* When playerX reaches right side of screen. */
    if (playerX <= -GAME_WIDTH/2.0) {
      player.setTranslateX(player.getTranslateX() + 20);
    }
    /* When player Y reaches bottom of screen. */
    if (playerY > GAME_HEIGHT/2.0) {
      player.setTranslateY(player.getTranslateY() - 20);
    }
    /* Reach the top, you win! */
    if (playerY < -GAME_HEIGHT/2.0) {
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
    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (!paused) {
          movePlayer();
          checkCollision();
        }
        pause();
        createPausePopup();
      }
    };
    timer.start();
  }
}