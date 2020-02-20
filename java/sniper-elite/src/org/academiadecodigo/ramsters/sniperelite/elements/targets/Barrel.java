package org.academiadecodigo.ramsters.sniperelite.elements.targets;

import org.academiadecodigo.ramsters.sniperelite.elements.GameObject;

public class Barrel extends GameObject implements Destroyable {

    @Override
    public boolean isDestroyed() {

        return false;

    }

    @Override
    public void hit(int damage) {



    }

    @Override
    public String getMessage() {

        return null;

    }

}
