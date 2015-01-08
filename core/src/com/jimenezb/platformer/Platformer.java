package com.jimenezb.platformer;


import com.badlogic.gdx.Game;
import com.jimenezb.platformer.view.GameScreen;


public class Platformer extends Game {
    @Override
    public void create() {
    setScreen(new GameScreen());//the screen of the game.
    }
}
