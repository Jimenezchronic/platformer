package com.jimenezb.platformer.controller;


import com.badlogic.gdx.math.Vector2;
import com.jimenezb.platformer.model.Enemy;




public class EnemyController {

    public static Enemy enemy; //creating the enemy`

     public static void initializecontroller(){
        enemy= new Enemy(new Vector2(0,0), 70, 100, "img/enemy.png");

    }

    public static void update( float deltatime){
    enemy.update(deltatime);
    }
}

