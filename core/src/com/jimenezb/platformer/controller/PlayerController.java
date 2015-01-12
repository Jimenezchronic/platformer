package com.jimenezb.platformer.controller;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.jimenezb.platformer.model.Player;

public class PlayerController {

public static Player player; //creating the player

public static void initializecontroller(){

    player= new Player(70, 100);
}
 public static void update(float deltatime){
     player.update(deltatime); //updates the position
 }
public static void draw(Batch SpriteBatch){
    player.draw(SpriteBatch);
}

}
