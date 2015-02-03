package com.jimenezb.platformer.model;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.jimenezb.platformer.controller.LevelController;

public class Enemy extends Sprite {

    public Enemy(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        BodyDef bodydefinition = new BodyDef();
        bodydefinition.type = BodyDef.BodyType.DynamicBody;
        bodydefinition.position.set(position);
        phyicsBody = LevelController.gameworld.createBody(bodydefinition);
        phyicsBody.setUserData(this);

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width/2f, this.height/2f,  new Vector2(this.width / 2f, this.height /2f), 0f);
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        phyicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();

        animations.put("stand", spritesheet.createAnimation(0, 0, 0.5f));
            currentAnimation = "stand";


    }
    public void draw(Batch spriteBatch) { //draw the images on our spritesheet
        super.draw(spriteBatch);
    }
    public void update(float deltaTime){ // it changes the specifics of the player
        super.update(deltaTime);
    }
}
