package com.bayramkaya.tank.addItems;

import com.bayramkaya.tank.gameObjects.GameObject;
import com.bayramkaya.tank.tank.Tank;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<GameObject> loadGameObjectInfo() {
        ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
        File file = new File("gameObject1.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    GameObject gameObject = (GameObject) input.readObject();
                    gameObjects.add(gameObject);
                } catch (EOFException e) {
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data has been saved.");
        }
        return gameObjects;
    }


    public static void saveGameObjectInfos(ArrayList<GameObject> gameObjects) {
        File file = new File("gameObject1.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (GameObject gameObject : gameObjects) {
                try {
                    output.writeObject(gameObject);
                } catch (IOException e) {
                    System.out.println("An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Tank> loadTanksInfo() {
        ArrayList<Tank> tanks = new ArrayList<Tank>();
        File file = new File("tank1.info");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    Tank tank = (Tank) input.readObject();
                    tanks.add(tank);
                } catch (EOFException e) {
                    break;
                } catch (Exception e) {
                    System.out.println("Problem with some of the records in the data file");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("No previous data has been saved.");
        }
        return tanks;
    }


    public static void saveTanksInfos(ArrayList<Tank> tanks) {
        File file = new File("tank1.info");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
            for (Tank tank : tanks) {
                try {
                    output.writeObject(tank);
                } catch (IOException e) {
                    System.out.println("An error occurred while trying to save info");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to save info");
            System.out.println(e.getMessage());
        }
    }
}
