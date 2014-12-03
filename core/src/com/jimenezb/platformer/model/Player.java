package com.jimenezb.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; // a point for X and Y
    public Texture spritesheet; //storing an image

    public Player() {
        position = new Vector2(0, 0); //selecting the position for my player.
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png")); //accessing the img folder to get the aliens.png
    }

public void draw(Batch spriteBatch){ //draw the images on our spritesheet
spriteBatch.draw(spritesheet, 0, 0, 70, 100);
}
public void update(float deltaTime){ // it changes the specifics of the player

}
}
