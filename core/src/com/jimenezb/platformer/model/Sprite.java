package com.jimenezb.platformer.model;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.jimenezb.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body phyicsBody;
    public Vector2 position; // a point for X and Y
    public float width;
    public float height;
    public Spritesheet spritesheet;
    public String currentAnimation;
    protected float stateTime;
    protected HashMap<String, Animation> animations;

    public Sprite(Vector2 position, int width, int height) {
        position = new Vector2(0, 3); //selecting the position for my player.
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;
        spritesheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
    }
    public void draw(Batch spriteBatch) { //draw the images on our spritesheet
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true) ,position.x , position.y , 70* (1/70f) , 100*(1/70f)); //selecting which spriteframe to display

    }
    public void update(float deltaTime){ // it changes the specifics of the player
        stateTime  += deltaTime;

    }
}

