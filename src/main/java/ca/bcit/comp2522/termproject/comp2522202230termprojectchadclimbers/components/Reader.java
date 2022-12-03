package ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.components;

import ca.bcit.comp2522.termproject.comp2522202230termprojectchadclimbers.ChadClimbers;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Handles all JSON objects.
 * @author Oscar
 * @version 2022
 */
public class Reader {
  private SaveFile saveFileObject;

  /**
   * Type annotation for SaveFile JSON object.
   * @author Oscar
   * @version 2022
   */
  public class SaveFile {
    public String saveId;
    public Score score;
    public Inventory inventory;

    public class Score {
      public int wins;
      public int losses;
    }

    public class Inventory {
      public ArrayList<String> players;
      public ArrayList<String> buffs;
    }
  }

  /**
   * Reads the JSON file saveFile.
   * @throws FileNotFoundException if json file does not exist.
   * @throws URISyntaxException if URI path does not exist.
   */
  public void readJSON() throws FileNotFoundException, URISyntaxException {
    Gson gson = new Gson();
    File saveFile = new File(ChadClimbers.class.getResource("saves/save1.json").toURI());
    FileReader fileReader = new FileReader(saveFile);
    saveFileObject = gson.fromJson(fileReader, SaveFile.class);
  }

  /**
   * Returns the SaveFile saveFileObject
   * @return saveFileObject SaveFile
   */
  public SaveFile getSaveFileObject() {
    return saveFileObject;
  }
}
