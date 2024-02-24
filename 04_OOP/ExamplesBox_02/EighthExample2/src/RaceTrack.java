import car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceTrack {
    private final int distance;
    private final List<Car> cars = new ArrayList<>();

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> startRace() {
        List<Car> finishedCars = new ArrayList<>();
        while (finishedCars.size() < cars.size()) {
            for (Car car : cars) {
                car.moveRandomly();
                if (car.getX() >= distance) {
                    finishedCars.add(car);
                }
            }
        }
        Collections.sort(finishedCars, (c1, c2) -> (int) (c1.getFinishTime(distance) - c2.getFinishTime(distance)));
        return finishedCars;
    }

    private void showResults(List<Car> finishedCars) {
        System.out.println("Race results:");
        for (int i = 0; i < finishedCars.size(); i++) {
            Car car = finishedCars.get(i);
            System.out.println((i + 1) + ". place: " + car + ", finish time: " + car.getFinishTime(distance));
        }
    }

    public void runRace() {
        List<Car> finishedCars = startRace();
        showResults(finishedCars);
    }
}
