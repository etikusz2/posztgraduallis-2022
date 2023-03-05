import javax.swing.*;
import java.util.Arrays;

public class RaceController {
    private Car[] cars;
    private CarController[] carControllers;
    private RaceTrack raceTrack;
    private TrackRefresher trackRefresher;
    private RaceFrame raceFrame;
    private int finishedCars;

    public RaceController(int numberOfCars) {
        cars = new Car[numberOfCars];
        carControllers = new CarController[numberOfCars];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(i + 1);
            carControllers[i] = new CarController(cars[i], this);
        }
        raceTrack = new RaceTrack();
        raceTrack.setCars(cars);
        trackRefresher = new TrackRefresher(raceTrack);
        raceFrame = new RaceFrame(raceTrack, this);
        raceFrame.setBounds(10, 10, 1024, 768);
        raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        raceFrame.setVisible(true);
        finishedCars = 0;
    }

    public void initRace(int numberOfCars) {
        cars = new Car[numberOfCars];
        carControllers = new CarController[numberOfCars];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(i + 1);
            carControllers[i] = new CarController(cars[i], this);
        }
        raceTrack.setCars(cars);
        trackRefresher = new TrackRefresher(raceTrack);
        finishedCars = 0;
    }

    public void startRace() {
        for (int i = 0; i < carControllers.length; i++) {
            carControllers[i].start();
        }
        trackRefresher.start();
    }

    public void carFinished(Car car) {
        finishedCars++;
        if (finishedCars == cars.length) {
            String message = "The race is over!\nResult:\n";
            Arrays.sort(cars, (c1, c2) -> c2.getX() - c1.getX()); // rendezés a beérkezés sorrendjében
            for (int i = 0; i < cars.length; i++) {
                message += (i + 1) + ". place: Car " + cars[i].getCarNumber() + "\n";
            }
            JOptionPane.showMessageDialog(null, message);
            finishedCars = 0;
            RaceController.finished = true;
        }
    }

    public static final int TRACK_LENGHT = 780;
    public static volatile boolean finished = false;
}

