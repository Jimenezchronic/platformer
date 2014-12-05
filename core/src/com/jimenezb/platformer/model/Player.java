package com.jimenezb.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import sun.font.TextRecord;

public class Player {
    public Vector2 position; // a point for X and Y
    public Texture spritesheet; //storing an image
    public TextureRegion[] spriteFrames; //an array of regions of the texture.

    public Player() {
        position = new Vector2(0, 3); //selecting the position for my player.
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png")); //accessing the img folder to get the aliens.png
        TextureRegion[][] spritesheetFrames = TextureRegion.split(spritesheet, 70, 100);//it splits up our spritesheet  to fit our texture region

        int counter = 0; // counts how many spritesheets are in our texture
        for (int row = 0; row < spritesheetFrames.length; row++) { //selecting rows to select a spritesheet
            for (int column = 0; column < spritesheetFrames[row].length; column++) { //selecting a column to select a spritesheet
                counter++;    //adds 1 to the counter
            }
        }
        spriteFrames = new TextureRegion[counter]; //initializes the spriteframes,makes space cause of counter
        counter = 0; //resets the counter
        for (TextureRegion[] row : spritesheetFrames) { // accesses our 2 dimensional spritesheet
            for (TextureRegion sprite : row) {
                spriteFrames[counter++] = sprite; //adds one to the spriteframes array
            }
        }
    }

    public void draw(Batch spriteBatch) { //draw the images on our spritesheet
    spriteBatch.draw(spriteFrames[44],position.x , position.y , 70* (1/70f) , 100*(1/70f)); //selecting which spriteframe to display
}
public void update(float deltaTime){ // it changes the specifics of the player
position.x += deltaTime; // limits the players on how fast it goes

}
}
