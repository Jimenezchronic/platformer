package com.jimenezb.platformer.model;


import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.jimenezb.platformer.controller.PlayerController;

import java.lang.reflect.Field;

public class CollisionListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture FixtureA = contact.getFixtureA();
        Fixture FixtureB = contact.getFixtureB();

        boolean sensorA = FixtureA.isSensor();
        boolean sensorB = FixtureB.isSensor();


        if (sensorA || sensorB){
            PlayerController.grounded = true;
        }

            }



    @Override
    public void endContact(Contact contact) {
    System.out.println("End Contact");
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
