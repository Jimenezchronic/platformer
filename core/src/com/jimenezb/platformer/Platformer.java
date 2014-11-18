package com.jimenezb.platformer;


import com.badlogic.gdx.Game;
import com.jimenezb.platformer.view.gamescreen;


public class Platformer extends Game {
    @Override
    public void create() {
    setScreen(new gamescreen());//the screen of the game.
    }
}
