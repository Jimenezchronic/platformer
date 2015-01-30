package com.jimenezb.platformer.controller;



import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.jimenezb.platformer.model.Player;

public class PlayerController {

public static Player player; //creating the player
    public  static String movementAction;
    public static String specialAction;
    private static final float VELOCITY = 1f;
    public static  boolean grounded;
    private static  final float MAX_VELOCITY = 5f;
    private enum State{
        Idle, Walk, Duck, Jump, Climb, Swim, Hurt,
    }
    private  static  State playerState;

public static void initializecontroller(){
    player= new Player(new Vector2(4,4), 70, 100, "img/aliens.png");
    movementAction = "";
    specialAction = "";
    grounded = false;
    playerState = State.Idle;
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
        player.directinon="right";
    }

    else if(movementAction .equalsIgnoreCase("left")){
    player.directinon="left";
    }
    if (Math.abs(velocity.x) > 0){
        playerState = State.Walk;
        }
    else{
        playerState = State.Idle;
        }
            setCurrentAnimation();
    }
    private static void setCurrentAnimation(){
        if (player.directinon.equals("right")){
            setRightAnimation();
        }
        else if (player.directinon.equals("left")){
            setLeftAnimation();
        }
    }

    private static void setLeftAnimation(){
        if (playerState == State.Walk){
            player.currentAnimation = "walkleft";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleleft";
        }
    }
    private static void setRightAnimation(){
        if (playerState == State.Walk){
            player.currentAnimation = "walkright";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleright";
        }
    }

}

