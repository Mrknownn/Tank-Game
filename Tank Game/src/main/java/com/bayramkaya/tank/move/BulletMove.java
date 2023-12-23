package com.bayramkaya.tank.move;

import com.bayramkaya.tank.Bullet.Bullet;
import com.bayramkaya.tank.Main;
import com.bayramkaya.tank.gameObjects.GameObject;
import com.bayramkaya.tank.tank.PlayerTank;
import javafx.scene.Group;
import javafx.stage.Stage;

public class BulletMove {
    public static void moveBullets(PlayerTank playerTank, Group root, Stage stage) {
        for (GameObject gameObject : Main.gameObjects) {
            if (gameObject instanceof com.bayramkaya.tank.Bullet.Bullet) {
                ((Bullet) gameObject).moveType(playerTank, root, stage);
            }
        }
    }
}
