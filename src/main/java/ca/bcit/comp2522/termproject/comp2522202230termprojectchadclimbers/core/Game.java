package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.EnemyClass;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components.Pause;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Enemy;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Player;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.ChadStage;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.Level;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.common.PlayerClass;
import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.core.entities.Stats;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * Game Module.
 *
 * @author Oscar && Atsuki
 * @version 2022
 */
public class Game {
 private static final int GAME_WIDTH = 800;
  private static final int GAME_HEIGHT = 600;
  private static final int ROTATE_360 = 360;
  private static final int ROTATE_180 = 180;
  private static final int ROTATE_90 = 90;
  private ArrayList<Enemy> enemies = new ArrayList<>();
  private Player player;
  private PlayerClass playerClass;
  private ChadStage chosenStage;
  private GridPane gamePane;
  private Scene gameScene;
  private Stage gameStage;
  private StackPane pausePane;
  private Level chosenLevel;
  private Stats playerStats;
  private AnimationTimer timer;
  private long later;
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
   * @param chosenStage ChadStage
   * @param chosenLevel int
   */
  public void createNewGame(
      final PlayerClass playerClass,
      final ChadStage chosenStage,
      final Level chosenLevel
  ) {
    this.chosenLevel = chosenLevel;
    this.chosenStage = chosenStage;
    this.playerClass = playerClass;

    initialiseStage();
    populateEnemies();
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
    playerStats = playerClass.getStats();
    gamePane.getChildren().add(player.create());

  }

  /**
   * Adds enemy to the ArrayList enemies corresponding to
   * the level.
   */
  private void populateEnemies() {
    int i = 0;
    while (i < (chosenLevel.getSelectedLevel() + 1) * 5) {
      enemies.add(createEnemy());
      i++;
    }
  }

  /**
   * Creates the enemy.
   * @return Enemy enemy
   */
  private Enemy createEnemy() {
    Random rng = new Random();
    Enemy enemy = new Enemy(EnemyClass.values()[chosenLevel.getSelectedLevel()]);
    enemy.create().setTranslateY(rng.nextDouble(-GAME_HEIGHT/2.0 + enemy.height, GAME_HEIGHT/2.0 - enemy.height*2.5));
    enemy.create().setTranslateX(rng.nextDouble(-GAME_WIDTH/2.0, GAME_WIDTH/2.0));
    gamePane.getChildren().add(enemy.create());
    return enemy;
  }

  /**
   * Initialises a Pane object to create the game stage.
   */
  private void initialiseStage() {
    gamePane = new GridPane();
    gamePane.setAlignment(Pos.CENTER);
    gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
    gamePane.setBackground(new Background(new BackgroundImage(
       chosenStage.getImage(),
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
        case LEFT, A -> isLeftKeyPressed = true;
        case RIGHT, D -> isRightKeyPressed = true;
        case UP, W -> isUpKeyPressed = true;
        case DOWN, S -> isDownKeyPressed = true;
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
   * Simple collision detection between enemies and player.
   */
  private void collisionCheck() {
    for (Enemy enemy : enemies) {
      if (enemy.create().getBoundsInParent().intersects(player.create().getBoundsInParent())) {
        player.create().setTranslateY(GAME_HEIGHT/2.0);
        playerStats.currentHP = playerStats.currentHP - enemy.stats.strength;
        System.out.println(playerStats.currentHP);
        return;
      }
    }
  }

  /**
   * Iterates each enemy to move them.
   * @param now long.
   */
  private void moveEnemy(final long now) {
    final long wait = 300000000;
    if (later == 0 || now >= later) {
      later = now + wait;
    } else {
      return;
    }

    for (Enemy enemy : enemies) {
      double enemyMoveUnits;
      enemyMoveUnits = enemy.move();
      if (
        enemyMoveUnits <= -GAME_WIDTH / 2.0 ||
        enemyMoveUnits >= GAME_WIDTH / 2.0
    ) {
      return;
    } else {
      enemy.create().setTranslateX(enemyMoveUnits);
      }
    }
  }

  /**
   * Handle events `set true` key stroke variables.
   * Handles boundary detections and sprite rotation.
   */
  private void movePlayer() {
    double moveUnits;
    if (isUpKeyPressed) {
      isUpKeyPressed = false;
      moveUnits = player.moveUp();
      /* Reach the top, you win! */
      if (moveUnits <= -GAME_HEIGHT / 2.0) {
        win = true;
        return;
      }
      player.create().setTranslateY(moveUnits);
      player.create().setRotate(ROTATE_180);
    }
    if (isDownKeyPressed) {
      isDownKeyPressed = false;
      moveUnits = player.moveDown();
      /* When player Y reaches bottom of screen. */
      if (moveUnits >= GAME_HEIGHT / 2.0) return;
      player.create().setTranslateY(moveUnits);
      player.create().setRotate(ROTATE_360);
    }
    if (isLeftKeyPressed) {
      isLeftKeyPressed = false;
      moveUnits = player.moveLeft();
      /* When playerX reaches left side of the screen. */
      if (moveUnits <= -GAME_WIDTH / 2.0) return;
      player.create().setTranslateX(moveUnits);
      player.create().setRotate(ROTATE_90);
    }
    if (isRightKeyPressed) {
      isRightKeyPressed = false;
      moveUnits = player.moveRight();
      /* When playerX reaches right side of screen. */
      if (moveUnits >= GAME_WIDTH / 2.0) return;
      player.create().setTranslateX(moveUnits);
      player.create().setRotate(-ROTATE_90);
    }
  }

  /**
   * When win value is true, timer
   * will stop, player position resets, and
   * gameStage will close.
   */
  private void checkStatus() {
    if (win) {
      timer.stop();
      System.out.println("Win");
      gameStage.close();
    }

    if (playerStats.currentHP <= 0) {
      timer.stop();
      playerStats.currentHP = playerClass.getStats().maxHP;
      System.out.println("You Died");
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
          moveEnemy(now);
          collisionCheck();
          checkStatus();
        }
        pause();
        createPausePopup();
      }
    };
    timer.start();
  }
}