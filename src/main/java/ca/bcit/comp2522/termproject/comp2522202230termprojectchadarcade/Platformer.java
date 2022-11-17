package ca.bcit.comp2522.termproject.comp2522202230termprojectchadarcade;

import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;



public class Platformer {
    World<Body> stage = new World<>();
    private Double x;
    private Double y;

    public Platformer(){
    }
    private static final Object CHARACTER = new Object();
    private static final Object FLOOR = new Object();

    protected void initializeWorld(){
        //create floor
        Body floor = new Body();
        floor.addFixture(Geometry.createRectangle(50,0.2));
        floor.setMass(MassType.INFINITE);
        floor.translate(0, -6);
        floor.setUserData(FLOOR);
        stage.addBody(floor);

        // make character and put it on stage
        Body body = new Body();
        body.addFixture(Geometry.createRectangle(0.3, 1.7));
        body.setMass(MassType.NORMAL);
        body.translate(0,50);
        body.setUserData(CHARACTER);
        stage.addBody(body);

        // make right side of stage
        Body right = new Body();
        right.addFixture(Geometry.createRectangle(0.2, 25.7));
        right.setMass(MassType.INFINITE);
        right.translate(10, 7);
        stage.addBody(right);

        // make left side of stage
        Body left = new Body();
        left.addFixture(Geometry.createRectangle(0.2, 25.7));
        left.setMass(MassType.INFINITE);
        left.translate(-10, 7);
        stage.addBody(left);
    }

    public final double getY(){
        return this.y == null ? 0.0 : this.y.get();
    }

    public static void main(String[] args) {
    }

}
