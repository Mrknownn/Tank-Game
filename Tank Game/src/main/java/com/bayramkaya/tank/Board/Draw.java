package com.bayramkaya.tank.Board;

import com.bayramkaya.tank.Bullet.Bullet;
import com.bayramkaya.tank.Main;
import com.bayramkaya.tank.grass.Grass;
import com.bayramkaya.tank.flag.Flag;
import com.bayramkaya.tank.gameObjects.GameObject;
import com.bayramkaya.tank.tank.ArmoredTank;
import com.bayramkaya.tank.tank.PlayerTank;
import com.bayramkaya.tank.tank.RandomTank;
import com.bayramkaya.tank.tank.RegularTank;
import com.bayramkaya.tank.wall.ColumnWall;
import com.bayramkaya.tank.wall.IronWall;
import com.bayramkaya.tank.wall.RegularWall;
import com.bayramkaya.tank.wall.RowWall;
import javafx.scene.canvas.GraphicsContext;

public class Draw {
    public static void draw(GraphicsContext gc, PlayerTank playerTank) {
        gc.clearRect(0, 0, 650, 650);
        for (GameObject gameObject : Main.gameObjects) {
            if (gameObject instanceof PlayerTank) {
                ((PlayerTank) gameObject).draw(gc);
            }
            if (gameObject instanceof RandomTank) {
                ((RandomTank) gameObject).draw(gc);
            }
            if (gameObject instanceof com.bayramkaya.tank.Bullet.Bullet) {
                gc.drawImage(((Bullet) gameObject).getImage(), gameObject.getX(), gameObject.getY(), 10, 10);
            }
            if (gameObject instanceof ArmoredTank) {
                ((ArmoredTank) gameObject).draw(gc);
            }
            if (gameObject instanceof RegularTank) {
                ((RegularTank) gameObject).draw(gc);
            }
            if (gameObject instanceof IronWall) {
                ((IronWall) gameObject).draw(gc);
            }
            if (gameObject instanceof RowWall) {
                ((RowWall) gameObject).draw(gc);
            }
            if (gameObject instanceof Flag) {
                ((Flag) gameObject).draw(gc);
            }
            if (gameObject instanceof ColumnWall) {
                ((ColumnWall) gameObject).draw(gc);
            }
            if (gameObject instanceof RegularWall) {
                ((RegularWall) gameObject).draw(gc);
            }
            if (gameObject instanceof com.bayramkaya.tank.grass.Grass) {
                gc.drawImage(((Grass) gameObject).getImage(), gameObject.getX(), gameObject.getY(), 50, 50);
            }
        }
    }
}
