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
import com.jimenezb.platformer.model.Player;

public class GameScreen implements Screen {
   public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;  //these are variables.
    public OrthographicCamera camera;
    public Batch spriteBatch; //draw sprites on the screen
    public Player player; //creating the player
    public static World gameworld;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        map = new TmxMapLoader().load("map/map1.tmx"); //loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);//telling render how wide and tall the map is.
        gameworld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

        //stores the width and height of the platformer window.
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height/width)); //this displays how much of the map we want to show and also fixes the stretching of the tiles.
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f,0); //adjusted my camera to fit the map.
        spriteBatch = renderer.getSpriteBatch(); // accessing the spritebatch to our levelmap
        player= new Player(70, 100);
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
        player.update(delta); //updates the position
        spriteBatch.begin(); //tells spritebatch to begin draws
        player.draw(spriteBatch);
        spriteBatch.end(); //tells spritebatch to ends draws
        debugRenderer.render(gameworld, camera.combined);
        gameworld.step(1/60f, 1, 1);
    }
}
