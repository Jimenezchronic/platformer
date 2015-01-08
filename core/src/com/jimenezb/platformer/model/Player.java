package com.jimenezb.platformer.model;



import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.jimenezb.platformer.view.GameScreen;


import java.util.HashMap;



public class Player {
    public Vector2 position; // a point for X and Y
    public float width;
    public float height;
    public Spritesheet spritesheet;
    public String currentAnimation;
    private float stateTime;
    private HashMap <String, Animation> animations;

    public Player(int width, int height) {
        position = new Vector2(0, 3); //selecting the position for my player.
        this.width = width * (1/70f);
        this.height = height * (1/70f);
        spritesheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        BodyDef bodydefinition = new BodyDef();
        bodydefinition.type = BodyDef.BodyType.DynamicBody;
        bodydefinition.position.set(position);
        Body playerBody = GameScreen.gameworld.createBody(bodydefinition);
        playerBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width/2f, this.height/2f,  new Vector2(this.width / 2f, this.height /2f), 0f);
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();


        animations.put("walk", spritesheet.createAnimation(9, 10, 0.5f));
        animations.put("climb" ,spritesheet.createAnimation(1, 2, 0.2f) );
        animations.put("ducking", spritesheet.createAnimation(3, 3, 0.5f));
        animations.put("hurting", spritesheet.createAnimation(4, 4, 0.5f));
        animations.put("jumping", spritesheet.createAnimation(5, 5, 0.5f));
        animations.put("stand", spritesheet.createAnimation(0, 0, 0.5f));
        animations.put("idle", spritesheet.createAnimation(6, 6, 0.5f));
        animations.put("swimming", spritesheet.createAnimation(7, 8, 0.5f));

        animations.put("walkleft", spritesheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("duckleft", spritesheet.flipAnimation(animations.get("ducking"), true, false));
        animations.put("hurtleft", spritesheet.flipAnimation(animations.get("hurting"), true, false));
        animations.put("jumpleft", spritesheet.flipAnimation(animations.get("jumping"), true, false));
        animations.put("swimleft", spritesheet.flipAnimation(animations.get("swimming"), true, false));
        animations.put("idleleft", spritesheet.flipAnimation(animations.get("idle"), true, false));

        currentAnimation         = "walkleft";

        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) { //draw the images on our spritesheet
    spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true) ,position.x , position.y , 70* (1/70f) , 100*(1/70f)); //selecting which spriteframe to display

    }
public void update(float deltaTime){ // it changes the specifics of the player
    stateTime  += deltaTime;

}
}
