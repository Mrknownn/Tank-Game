package com.bayramkaya.tank.wall;

import com.bayramkaya.tank.gameObjects.GameObject;

import java.io.Serializable;

public class Wall extends GameObject implements Serializable {
    int health;

    public Wall(int x, int y) {
        super(x, y);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
