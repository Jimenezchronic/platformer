package com.jimenezb.platformer.model;



import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;


public class Player {
    public Vector2 position; // a point for X and Y
    public Animation animation;
    public Spritesheet spritesheet;
    private float stateTime;
    public Player() {
        position = new Vector2(0, 3); //selecting the position for my player.
        spritesheet = new Spritesheet("img/aliens.png", 70, 100);
        animation = spritesheet.createAnimation(9, 10, 0.5f);
        animation = spritesheet.flipAnimation(animation, true, false);
        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) { //draw the images on our spritesheet
    spriteBatch.draw(animation.getKeyFrame(stateTime, true) ,position.x , position.y , 70* (1/70f) , 100*(1/70f)); //selecting which spriteframe to display
}
public void update(float deltaTime){ // it changes the specifics of the player
    stateTime  += deltaTime;
    position.x += deltaTime; // limits the players on how fast it goes

}
}
