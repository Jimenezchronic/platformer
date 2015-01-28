package com.jimenezb.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.jimenezb.platformer.model.Player;

public class PlayerController {

public static Player player; //creating the player
    public  static String movementAction;
    public static String specialAction;
    private static final float VELOCITY = 1f;
    private static final float VELOCITY1 = -1f;
    private static  final float MAX_VELOCITY = 5f;

public static void initializecontroller(){
    player= new Player(new Vector2(4,4), 70, 100, "img/aliens.png");
    movementAction = "";
    specialAction = "";
}
 public static void update(float deltatime){
     handleInput();
     player.update(deltatime); //updates the position
 }
public static void draw(Batch SpriteBatch){
    player.draw(SpriteBatch);
}
private static void handleInput(){
    Vector2 velocity = player.phyicsBody.getLinearVelocity();
    Vector2 position = player.phyicsBody.getPosition();

    if(velocity.x > MAX_VELOCITY){
        velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
        player.phyicsBody.setLinearVelocity(velocity.x, velocity.y);
    }

    if(movementAction .equalsIgnoreCase("right")){
        player.phyicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
    }

    else if(movementAction .equalsIgnoreCase("left")){

    }
}
}
