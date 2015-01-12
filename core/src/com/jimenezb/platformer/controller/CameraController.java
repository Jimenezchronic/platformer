package com.jimenezb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public  static  void initializeController(){
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height/width)); //this displays how much of the map we want to show and also fixes the stretching of the tiles.
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f,0); //adjusted my camera to fit the map.
    }
    public static  void update(){
        camera.update();
    }

    public  static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width; //our new height and width
        camera.update(); //updating the camera
    }
}
