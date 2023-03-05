import java.util.Random;

public class CarController extends Thread {
    private final Car car;
    private final Random random;
    private final RaceController raceController;

    public CarController(Car car, RaceController raceController) {
        this.car = car;
        this.raceController = raceController;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!RaceController.finished && car.getX() < RaceController.TRACK_LENGHT) {
            car.setX(car.getX() + random.nextInt(5));
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (car.getX() >= RaceController.TRACK_LENGHT) {
            raceController.carFinished(car);
        }
    }
}