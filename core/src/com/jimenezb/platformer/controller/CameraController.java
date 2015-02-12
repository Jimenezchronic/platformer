package com.jimenezb.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;
    public  static  float widthscale;
     public static float heightscale;

    public  static  void initializeController(){
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(14f, 14f * (height/width)); //this displays how much of the map we want to show and also fixes the stretching of the tiles.
        camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f,0); //adjusted my camera to fit the map.
        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set( inputCamera.viewportWidth / 2f,inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }
    public static  void update(){
       camera.position.set(PlayerController.player.position.x,PlayerController.player.position.y, 0  );
        camera.update();
    }

    public  static void resize(int width, int height){
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width; //our new height and width
        camera.update(); //updating the camera
        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height / width;
        inputCamera.update();
        widthscale = width /inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightscale = height/inputCamera.viewportHeight * LevelController.UNIT_SCALE;
    }
}
