package com.jimenezb.platformer.view;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class gamescreen implements Screen {
   public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;  //these are variables.
    public OrthographicCamera camera;

    public gamescreen() {
        map = new TmxMapLoader().load("map/map1.tmx"); //loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//telling render how wide and tall the map is.

        //stores the width and height of the platformer window.
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height/width)); //this displays how much of the map we want to show and also fixes the stretching of the tiles.
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f,0); //adjusted my camera to fit the map.
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
       camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width; //our new height and width
        camera.update(); //updating the camera


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.12f, 0.70f, 0.70f, 1f); //SELECTING A COLOR
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //CLEARING THE SCREEN USING A COLOR WE HAVE CHOSEN
        camera.update();
        renderer.setView(camera);
        renderer.render(); //it renders
    }
}
