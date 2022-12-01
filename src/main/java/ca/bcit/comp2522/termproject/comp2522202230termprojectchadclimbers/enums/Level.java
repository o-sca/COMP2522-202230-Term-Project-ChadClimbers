package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.enums;

/**
 * Enum class for Level.
 * @author Oscar
 * @version 2022
 */
public enum Level {
  EASY(0),
  MEDIUM(1),
  HARD(2),
  ONI(3);

  private final int selectedLevel;

  /**
   * Constructs the object type Level.
   * @param selectedLevel int
   */
  Level(final int selectedLevel) {
    this.selectedLevel = selectedLevel;
  }

  /**
   * Return the selectedLevel value.
   * @return selectedLevel int
   */
  public int getSelectedLevel() {
    return selectedLevel;
  }
}
