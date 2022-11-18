package ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.AABB;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;
import org.tiledreader.*;


public class Platformer extends Application {
    TiledReader tileFile = new FileSystemTiledReader();
    private final World<Body> stage = new World<>();
    private Double x;
    private Double y;
    public Platformer(){
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeWorld();
        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setScene(scene);
        stage.show();


    }

    private static final Object CHARACTER = new Object();
    private static final Object FLOOR = new Object();

    protected void initializeWorld(){
        TiledMap tiledMap = tileFile.getMap(HelloApplication.class.getResource("/collision.tmx").getPath());
        for(TiledLayer layer: tiledMap.getTopLevelLayers()){
            if(layer instanceof TiledObjectLayer){
                TiledObjectLayer tileObj =  (TiledObjectLayer) layer;
                for(TiledObject tiledObject: tileObj.getObjects()) {
                    Body body = new Body();
                    body.addFixture(Geometry.createRectangle(tiledObject.getWidth(), tiledObject.getHeight()));
                    body.translate(tiledObject.getX(), tiledObject.getY());
                    body.setMass(MassType.INFINITE);
                    stage.addBody(body);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
