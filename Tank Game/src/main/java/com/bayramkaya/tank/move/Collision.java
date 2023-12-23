package com.bayramkaya.tank.move;

import com.bayramkaya.tank.Main;
import com.bayramkaya.tank.gameObjects.GameObject;
import com.bayramkaya.tank.tank.PlayerTank;
import com.bayramkaya.tank.tank.Tank;
import com.bayramkaya.tank.wall.ColumnWall;

public class Collision {
    public static boolean checkCollision(Tank playerTank) {
        int playerX = playerTank.getX();
        int playerY = playerTank.getY();
        if (playerTank.getDirection() == 8) {
            playerY -= playerTank.getSpeed();
        } else if (playerTank.getDirection() == 2) {
            playerY += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 6) {
            playerX += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 4) {
            playerX -= playerTank.getSpeed();
        }
        for (com.bayramkaya.tank.gameObjects.GameObject gameObject : com.bayramkaya.tank.Main.gameObjects) {
            if (!gameObject.equals(playerTank)) {
                if (!(gameObject instanceof ColumnWall)) {
                    if (playerX > gameObject.getX() - 49 && playerX < gameObject.getX() + 49 &&
                            playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                        return false;
                    }
                } else {
                    if (playerX > gameObject.getX() - 24 && playerX < gameObject.getX() + 24 &&
                            playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean checkCollisionOtherTank(Tank playerTank) {
        int playerX = playerTank.getX();
        int playerY = playerTank.getY();
        if (playerTank.getDirection() == 8) {
            playerY -= playerTank.getSpeed();
        } else if (playerTank.getDirection() == 2) {
            playerY += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 6) {
            playerX += playerTank.getSpeed();
        } else if (playerTank.getDirection() == 4) {
            playerX -= playerTank.getSpeed();
        }
        for (GameObject gameObject : Main.gameObjects) {
            if ((!gameObject.equals(playerTank) && !(gameObject instanceof Tank)) || gameObject instanceof PlayerTank) {
                if (!(gameObject instanceof ColumnWall)) {
                    if (playerX > gameObject.getX() - 49 && playerX < gameObject.getX() + 49 &&
                            playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                        return false;
                    }
                } else {
                    if (playerX > gameObject.getX() - 24 && playerX < gameObject.getX() + 24 &&
                            playerY > gameObject.getY() - 49 && playerY < gameObject.getY() + 49) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
