package com.jimenezb.platformer.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jimenezb.platformer.controller.CameraController;
import com.jimenezb.platformer.controller.LevelController;
import com.jimenezb.platformer.controller.PlayerController;
import com.jimenezb.platformer.model.Player;

public class GameScreen implements Screen {
 //these are variables.



    public GameScreen() {
        LevelController.initializecontroller();
        CameraController.initializeController();
        PlayerController.initializecontroller();






    }

    @Override
    public void dispose() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void show() {

    }

    @Override
    public void resize(int width, int height) {
 CameraController.resize( width, height);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.12f, 0.70f, 0.70f, 1f); //SELECTING A COLOR
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //CLEARING THE SCREEN USING A COLOR WE HAVE CHOSEN

        LevelController.update(delta);
        CameraController.update();
      PlayerController.update(delta);
        LevelController.draw();


    }
}
