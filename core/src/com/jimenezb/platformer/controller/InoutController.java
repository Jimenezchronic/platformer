package com.jimenezb.platformer.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.jimenezb.platformer.model.InputControl;
import com.jimenezb.platformer.model.Spritesheet;

public class InoutController {
    private static Spritesheet spriteSheet;
    private static InputControl right;

    public static void initializeController() {
        spriteSheet = new Spritesheet("img/touch-controls.png ", 80, 80);
        right = new InputControl(new Vector2(0, 0), spriteSheet.spriteFrames[1], "right");
        Gdx.input.setInputProcessor(createInputAdapter());
    }

    public static void draw(Batch spriteBatch) {
        spriteBatch.begin();
        right.draw(spriteBatch);
        spriteBatch.end();
    }

    private static InputAdapter createInputAdapter() {
        return new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
               if (right.getBoundingBox().contains(screenX,Gdx.graphics.getHeight() - screenY)){
                   PlayerController.movementAction = "right";

               }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
               PlayerController.movementAction = "";
                return true;
            }
        };
    }
}
