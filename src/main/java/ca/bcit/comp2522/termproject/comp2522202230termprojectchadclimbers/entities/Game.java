package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.Pause;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Game Module.
 *
 * @author Oscar && Atsuki
 * @version 2022
 */
public class Game {
 private static final int GAME_WIDTH = 600;
  private static final int GAME_HEIGHT = 400;
  private static final int ROTATE_360 = 360;
  private static final int ROTATE_180 = 180;
  private static final int ROTATE_90 = 90;
  private Player player;
  private PlayerClass playerClass;
  private Image chosenStage;
  private GridPane gamePane;
  private Scene gameScene;
  private Stage gameStage;
  private StackPane pausePane;
  private AnimationTimer timer;
  private int chosenLevel = 1;
  private double moveUnits;
  private boolean isUpKeyPressed;
  private boolean isDownKeyPressed;
  private boolean isRightKeyPressed;
  private boolean isLeftKeyPressed;
  private boolean isSpaceBarPressed;
  private boolean isEscKeyPressed;
  private boolean paused;
  private boolean pausedPanePoppedUp;
  private boolean win = false;

  /**
   * Instantiate a new game.
   * @param playerClass PlayerClass
   * @param chosenStage Image
   * @param chosenLevel int
   */
  public void createNewGame(
      final PlayerClass playerClass,
      final Image chosenStage,
      final int chosenLevel
  ) {
    this.chosenLevel = (chosenLevel != 0) ? chosenLevel : 1;
    this.chosenStage = (chosenStage != null) ? chosenStage : new Image(ChadClimbers.class.getResourceAsStream("stages/stage1.png"));
    this.playerClass = (playerClass != null) ? playerClass : PlayerClass.BOY;

    initialiseStage();
    createPlayer();
    createKeyListener();
    createTick();
    gameStage.show();
  }

  /**
   * Constructs a player object.
   */
  private void createPlayer() {
    player = new Player(playerClass);
    player.resetPosition(GAME_HEIGHT);
    gamePane.getChildren().add(player.toImage());
  }

  /**
   * Initialises a Pane object to create the game stage.
   */
  private void initialiseStage() {
    gamePane = new GridPane();
    gamePane.setAlignment(Pos.CENTER);
    gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
    gamePane.setBackground(new Background(new BackgroundImage(
       chosenStage,
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
   * Handles boundary detections and sprite rotation.
   */
  private void movePlayer() {
    if (isUpKeyPressed) {
      isUpKeyPressed = false;
      moveUnits = player.moveUp();
      /* Reach the top, you win! */
      if (moveUnits <= -GAME_HEIGHT / 2.0) {
        win = true;
        return;
      }
      player.toImage().setTranslateY(moveUnits);
      player.toImage().setRotate(ROTATE_180);
    }
    if (isDownKeyPressed) {
      isDownKeyPressed = false;
      moveUnits = player.moveDown();
      /* When player Y reaches bottom of screen. */
      if (moveUnits >= GAME_HEIGHT / 2.0) return;
      player.toImage().setTranslateY(moveUnits);
      player.toImage().setRotate(ROTATE_360);
    }
    if (isLeftKeyPressed) {
      isLeftKeyPressed = false;
      moveUnits = player.moveLeft();
      /* When playerX reaches left side of the screen. */
      if (moveUnits <= -GAME_WIDTH / 2.0) return;
      player.toImage().setTranslateX(moveUnits);
      player.toImage().setRotate(ROTATE_90);
    }
    if (isRightKeyPressed) {
      isRightKeyPressed = false;
      moveUnits = player.moveRight();
      /* When playerX reaches right side of screen. */
      if (moveUnits >= GAME_WIDTH / 2.0) return;
      player.toImage().setTranslateX(moveUnits);
      player.toImage().setRotate(-ROTATE_90);
    }
  }

  /**
   * When win value is true, timer
   * will stop, player position resets, and
   * gameStage will close.
   */
  private void checkWinStatus() {
    if (win) {
      timer.stop();
      System.out.println("Win");
      gameStage.close();
    }
  }

  /**
   * Starts interval timer for recurring method calls.
   */
  private void createTick() {
   timer = new AnimationTimer() {
      @Override
      public void handle(final long now) {
        if (!paused) {
          movePlayer();
          checkWinStatus();
        }
        pause();
        createPausePopup();
      }
    };
    timer.start();
  }
}