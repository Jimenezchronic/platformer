package com.jimenezb.platformer.model;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spritesheet; //storing an image
    public TextureRegion[] spriteFrames; //an array of regions of the texture.

    public Spritesheet(String pathToFile, int width, int height) {
        spritesheet = new Texture(Gdx.files.internal(pathToFile)); //accessing the img folder to get the aliens.png
        TextureRegion[][] spritesheetFrames = TextureRegion.split(spritesheet, width, height);//it splits up our spritesheet  to fit our texture region

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
    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter]; //creating a array for 2 frames
        for (int index = lastFrame; index >= startFrame; index--) {
            animationFrames[--counter] = spriteFrames[index];
        }
        return new Animation(animationSpeed, animationFrames); //telling animation that each frame will last 1 second
    }
        public Animation flipAnimation(Animation originalAnimation, boolean flipX, boolean flipY){
       int frameCount = originalAnimation.getKeyFrames().length;
        TextureRegion[] flipFrames = new TextureRegion[frameCount];

        for(int index = 0; index <= frameCount - 1; index++){
            flipFrames[index] = new TextureRegion(originalAnimation.getKeyFrames()[index]);
            flipFrames[index].flip(flipX, flipY);
        }
        return new Animation(originalAnimation.getFrameDuration(), flipFrames);
    }
}
