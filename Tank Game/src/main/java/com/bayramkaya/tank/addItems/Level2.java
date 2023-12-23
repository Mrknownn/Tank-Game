package com.bayramkaya.tank.addItems;

import com.bayramkaya.tank.Main;
import com.bayramkaya.tank.tank.ArmoredTank;
import com.bayramkaya.tank.tank.RandomTank;
import com.bayramkaya.tank.tank.RegularTank;
import com.bayramkaya.tank.wall.ColumnWall;
import com.bayramkaya.tank.wall.IronWall;
import com.bayramkaya.tank.wall.RegularWall;
import com.bayramkaya.tank.wall.RowWall;

public class Level2 {
    public static void addObjects() {
        IronWall ironWall = new IronWall(275, 300);
        IronWall ironWall1 = new IronWall(325, 300);
        IronWall ironWall2 = new IronWall(225, 300);
        IronWall ironWall3 = new IronWall(375, 300);
        RowWall rowWall = new RowWall(275, 580);
        RowWall rowWall1 = new RowWall(325, 580);
        RegularWall regularWall = new RegularWall(150, 250);
        RegularWall regularWall1 = new RegularWall(150, 200);
        RegularWall regularWall2 = new RegularWall(450, 250);
        RegularWall regularWall3 = new RegularWall(450, 200);
        RegularWall regularWall4 = new RegularWall(150, 350);
        RegularWall regularWall5 = new RegularWall(150, 400);
        RegularWall regularWall6 = new RegularWall(450, 350);
        RegularWall regularWall7 = new RegularWall(450, 400);
        RegularWall regularWall8 = new RegularWall(450, 150);
        RegularWall regularWall9 = new RegularWall(450, 450);
        RegularWall regularWall10 = new RegularWall(150, 150);
        RegularWall regularWall11 = new RegularWall(150, 450);
        RegularWall regularWall12 = new RegularWall(450, 300);
        RegularWall regularWall13 = new RegularWall(150, 300);
        ColumnWall columnWall = new ColumnWall(275, 600);
        ColumnWall columnWall1 = new ColumnWall(355, 600);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall1);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall2);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall3);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall4);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall5);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall6);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall7);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall8);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall9);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall10);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall11);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall12);
        com.bayramkaya.tank.Main.gameObjects.add(regularWall13);
        com.bayramkaya.tank.Main.gameObjects.add(rowWall);
        com.bayramkaya.tank.Main.gameObjects.add(rowWall1);
        com.bayramkaya.tank.Main.gameObjects.add(columnWall1);
        com.bayramkaya.tank.Main.gameObjects.add(columnWall);
        com.bayramkaya.tank.Main.gameObjects.add(ironWall1);
        com.bayramkaya.tank.Main.gameObjects.add(ironWall2);
        com.bayramkaya.tank.Main.gameObjects.add(ironWall3);
        com.bayramkaya.tank.Main.gameObjects.add(ironWall);
        ArmoredTank armoredTank = new ArmoredTank(0, 0);
        ArmoredTank armoredTank1 = new ArmoredTank(600, 0);
        RegularTank regularTank = new RegularTank(200, 0);
        ArmoredTank armoredTank2 = new ArmoredTank(0, 0);
        RandomTank randomTank1 = new RandomTank(200, 0);
        RegularTank regularTank1 = new RegularTank(400, 0);
        RandomTank randomTank = new RandomTank(600, 0);
        RegularTank regularTank2 = new RegularTank(400, 0);
        com.bayramkaya.tank.Main.tanks.add(randomTank);
        com.bayramkaya.tank.Main.tanks.add(regularTank);
        com.bayramkaya.tank.Main.tanks.add(regularTank1);
        com.bayramkaya.tank.Main.tanks.add(armoredTank);
        com.bayramkaya.tank.Main.tanks.add(armoredTank1);
        com.bayramkaya.tank.Main.tanks.add(regularTank2);
        com.bayramkaya.tank.Main.tanks.add(armoredTank2);
        Main.tanks.add(randomTank1);
    }

}
