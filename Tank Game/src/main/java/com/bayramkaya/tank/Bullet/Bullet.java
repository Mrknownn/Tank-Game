package com.bayramkaya.tank.Bullet;

import com.bayramkaya.tank.Main;
import com.bayramkaya.tank.Ai.Ai;
import com.bayramkaya.tank.gameObjects.GameObject;
import com.bayramkaya.tank.grass.Grass;
import com.bayramkaya.tank.tank.PlayerTank;
import com.bayramkaya.tank.wall.RegularWall;
import com.bayramkaya.tank.wall.Wall;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Bullet extends GameObject {
    private int direction;

    private int speed = 8;

    public Image image;

    public com.bayramkaya.tank.tank.Tank shooter;

    public Bullet(int x, int y, com.bayramkaya.tank.tank.Tank shooter) {
        super(x, y);
        this.direction = shooter.getDirection();
        this.shooter = shooter;
        setX(setPositionX());
        setY(setPositionY());
        setPhoto();
        com.bayramkaya.tank.Main.gameObjects.add(this);
    }

    public int getDirection() {
        return direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public com.bayramkaya.tank.tank.Tank getShooter() {
        return shooter;
    }

    public void setShooter(com.bayramkaya.tank.tank.Tank shooter) {
        this.shooter = shooter;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setPhoto() {
        if (this.direction == 8) {
            image = new Image("file:images\\Bullet\\Up.png");
        } else if (this.direction == 4) {
            image = new Image("file:images\\Bullet\\Left.png");
        } else if (this.direction == 6) {
            image = new Image("file:images\\Bullet\\Right.png");
        } else if (this.direction == 2) {
            image = new Image("file:images\\Bullet\\Down.png");
        }
    }

    public Image getImage() {
        return image;
    }

    public int setPositionX() {
        int x = 0;
        if (shooter.getDirection() == 8) {
            x = shooter.getX() + 20;
        } else if (shooter.getDirection() == 2) {
            x = shooter.getX() + 20;
        } else if (shooter.getDirection() == 6) {
            x = shooter.getX() + 50;
        } else if (shooter.getDirection() == 4) {
            x = shooter.getX() - 20;
        }
        return x;
    }

    public int setPositionY() {
        int y = 0;
        if (shooter.getDirection() == 8) {
            y = shooter.getY() - 10;
        } else if (shooter.getDirection() == 2) {
            y = shooter.getY() + 50;
        } else if (shooter.getDirection() == 6) {
            y = shooter.getY() + 19;
        } else if (shooter.getDirection() == 4) {
            y = shooter.getY() + 20;
        }
        return y;
    }

    public void moveType(com.bayramkaya.tank.tank.PlayerTank playerTank, Group root, Stage stage) {
        Ai ai = new Ai();
        if (this.getShooter() instanceof com.bayramkaya.tank.tank.PlayerTank) {
            playerBullet(playerTank, root, stage);
        }
        if (this.getShooter() instanceof com.bayramkaya.tank.tank.ArmoredTank || this.getShooter() instanceof com.bayramkaya.tank.tank.RandomTank || this.getShooter() instanceof com.bayramkaya.tank.tank.RegularTank) {
            ai.aiBullet(this, root, stage);
        }
    }

    public void playerBullet(com.bayramkaya.tank.tank.PlayerTank playerTank, Group root, Stage stage) {
        if (this.direction == 8 && playerBulletCollision(playerTank, root, stage)) {
            this.setY(this.getY() - this.getSpeed());
        } else if (this.direction == 6 && playerBulletCollision(playerTank, root, stage)) {
            this.setX(this.getX() + this.getSpeed());
        } else if (this.direction == 4 && playerBulletCollision(playerTank, root, stage)) {
            this.setX(this.getX() - this.getSpeed());
        } else if (this.direction == 2 && playerBulletCollision(playerTank, root, stage)) {
            this.setY(this.getY() + this.getSpeed());
        }
        if (this.getX() < 0) {
            com.bayramkaya.tank.Main.gameObjects.remove(this);
        } else if (this.getX() > 650) {
            com.bayramkaya.tank.Main.gameObjects.remove(this);
        }
        if (this.getY() < 0) {
            com.bayramkaya.tank.Main.gameObjects.remove(this);
        } else if (this.getY() > 650) {
            com.bayramkaya.tank.Main.gameObjects.remove(this);
        }
    }

    public boolean playerBulletCollision(com.bayramkaya.tank.tank.PlayerTank playerTank, Group root, Stage stage) {
        int bulletX = this.getX();
        int bulletY = this.getY();
        if (this.direction == 8) {
            bulletY -= this.getSpeed();
        } else if (this.direction == 2) {
            bulletY += this.getSpeed();
        } else if (this.direction == 6) {
            bulletX += this.getSpeed();
        } else if (this.direction == 4) {
            bulletX -= this.getSpeed();
        }
        for (GameObject gameObject : com.bayramkaya.tank.Main.gameObjects) {
            if (gameObject instanceof Bullet || gameObject instanceof com.bayramkaya.tank.tank.PlayerTank || gameObject instanceof Grass) {
                continue;
            }
            if (bulletX > gameObject.getX() - 8 && bulletX < gameObject.getX() + 48 && bulletY > gameObject.getY() - 8 && bulletY < gameObject.getY() + 48) {
                Main.gameObjects.remove(this);
                if (gameObject instanceof com.bayramkaya.tank.tank.Tank) {
                    handleTank(gameObject,playerTank,root,stage);
                }
                if (gameObject instanceof Wall) {
                    if (gameObject instanceof RegularWall) {
                        showCollosionAnimationWall(root, stage, (Wall) gameObject);
                    }
                    ((Wall) gameObject).setHealth(((Wall) gameObject).getHealth() - 1);
                }
                return false;
            }
        }
        return true;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void showCollosionAnimationTank(Group root, Stage stage, com.bayramkaya.tank.tank.Tank tank) {
        // Load the image
        Image image = new Image("file:images\\Explode.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);


        imageView.setTranslateX(tank.getX());
        imageView.setTranslateY(tank.getY());

        ParallelTransition parallelTransition = new ParallelTransition();

        parallelTransition.setOnFinished((e) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), imageView);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        });

        parallelTransition.play();

        // Add the ImageView to the root group
        root.getChildren().add(imageView);

    }

    public static void showCollosionAnimationWall(Group root, Stage stage, Wall wall) {


        Image image = new Image("file:images\\Explode.png");

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);

        // Set initial position of the ImageView
        imageView.setTranslateX(wall.getX());
        imageView.setTranslateY(wall.getY());
        ParallelTransition parallelTransition = new ParallelTransition();

        parallelTransition.setOnFinished((e) -> {
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), imageView);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.play();
        });

        parallelTransition.play();
        root.getChildren().add(imageView);


    }

    public void handleTank(GameObject gameObject, PlayerTank playerTank, Group root, Stage stage){
        if (((com.bayramkaya.tank.tank.Tank) gameObject).getHealth() == 1) {
            if (gameObject instanceof com.bayramkaya.tank.tank.ArmoredTank || (gameObject instanceof com.bayramkaya.tank.tank.RandomTank && ((com.bayramkaya.tank.tank.RandomTank) gameObject).getTankType()==1) ) {
                playerTank.setPointRecieved(playerTank.getPointRecieved() + 200);
            }else {
                playerTank.setPointRecieved(playerTank.getPointRecieved() + 100);
            }
        }
        ((com.bayramkaya.tank.tank.Tank) gameObject).setHealth(((com.bayramkaya.tank.tank.Tank) gameObject).getHealth() - 1);
        showCollosionAnimationTank(root, stage, (com.bayramkaya.tank.tank.Tank) gameObject);
    }

}
