package car;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final int raceDistance;
    private final int numLanes;

    public Race(int numCars, int raceDistance) {
        this.raceDistance = raceDistance;
        numLanes = numCars / 2;
        for (int i = 0; i < numCars; i++) {
            Car car = new Car(0, 50 + i * 50, 20, getRandomColor());
            cars.add(car);
        }
    }

    private Color getRandomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    public void start() {
        RaceFrame frame = new RaceFrame();
        int finishCount = 0;
        while (finishCount < cars.size()) {
            for (Car car : cars) {
                if (car.getxPos() < raceDistance) {
                    car.moveRandomly();
                    int laneHeight = frame.getHeight() / numLanes;
                    int lane = car.getyPos() / laneHeight;
                    car.setLane(lane);
                    frame.repaint();
                } else if (car.getFinishTime(raceDistance) == 0) {
                    finishCount++;
                    car.setLane(-1);
                    if (finishCount == 1) {
                        JOptionPane.showMessageDialog(frame, "Winner: Car " + car.getId());
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Car> finishedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getFinishTime(raceDistance) == 0) {
                finishedCars.add(car);
            }
        }
        showResults(finishedCars);
    }

    public void showResults(List<Car> finishedCars) {
        System.out.println("Race results:");
        System.out.println("--------------");

        // Sort the finished cars by their finish time
        Collections.sort(finishedCars);

        // Print the finish position and time for each car
        int position = 1;
        for (Car car : finishedCars) {
            System.out.println(position++ + ". " + car.getName() + " finished in " + car.getFinishTime() + " seconds.");
        }

        // Print the non-finished cars
        if (!cars.isEmpty()) {
            System.out.println("\nNon-finished cars:");
            System.out.println("-------------------");
            for (Car car : cars) {
                System.out.println(car.getName() + " did not finish the race.");
            }
        }
    }