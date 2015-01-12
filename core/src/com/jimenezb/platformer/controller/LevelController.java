package com.jimenezb.platformer.controller;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.jimenezb.platformer.model.Level;

public class LevelController {
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch; //draw sprites on the screen
    public static World gameworld;
    private static Box2DDebugRenderer debugRenderer;
    public static final float UNIT_SCALE = 1/70f;
    public static Level level;

    public static void initializecontroller() {
        level = new Level("map/map1.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map,UNIT_SCALE);//telling render how wide and tall the map is.
        spriteBatch = renderer.getSpriteBatch(); // accessing the spritebatch to our levelmap
        gameworld = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();

    }
public static void draw(){
    spriteBatch.begin(); //tells spritebatch to begin draws
    PlayerController.draw(spriteBatch);
    spriteBatch.end(); //tells spritebatch to ends draws
    debugRenderer.render(gameworld, CameraController.camera.combined);
}
public  static  void update(float deltaTime){
    renderer.setView(CameraController.camera);
    renderer.render(); //it renders
    gameworld.step(1/60f, 1, 1);

}



}
