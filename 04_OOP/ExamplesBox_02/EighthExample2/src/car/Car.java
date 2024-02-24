package car;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Car {
    private static int carCount = 0;
    private final int id;
    private int xPos;
    private int yPos;
    private int speed;
    private Color color;
    private int lane;

    public Car(int xPos, int yPos, int speed, Color color) {
        carCount++;
        id = carCount;
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
        this.color = color;
    }

    public void move() {
        xPos += speed;
    }

    public void moveRandomly() {
        Random rand = new Random();
        xPos += rand.nextInt(11) - 5;
        speed += rand.nextInt(11) - 5;
        if (speed < 1) {
            speed = 1;
        }
    }

    public int getFinishTime(int raceDistance) {
        return (raceDistance - xPos) / speed;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }
}
