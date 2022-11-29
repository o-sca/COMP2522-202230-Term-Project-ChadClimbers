package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.entities;

import javafx.scene.image.ImageView;

public class Player {
  public ImageView player;

  private Player(Sprite sprite) {
    create(sprite);
  }

  private void create(Sprite chosenPlayer) {
    player = new ImageView(chosenPlayer.getURL());
  }
}
