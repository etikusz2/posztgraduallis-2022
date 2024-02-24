import car.Car;
import car.Race;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RaceFrame extends JFrame {
    private final Race race;
    private final List<Car> cars;

    public RaceFrame(Race race) {
        this.race = race;
        this.cars = race.getCars();

        setTitle("Race");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel racePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int roadWidth = getWidth() / race.getLanes();
                int roadHeight = getHeight() / cars.size();

                // Draw roads
                g.setColor(Color.BLACK);
                for (int i = 0; i <= race.getLanes(); i++) {
                    int x = i * roadWidth;
                    g.fillRect(x, 0, roadWidth / 5, getHeight());
                }

                // Draw cars
                for (int i = 0; i < cars.size(); i++) {
                    Car car = cars.get(i);

                    int x = car.getLane() * roadWidth + roadWidth / 2 - car.getWidth() / 2;
                    int y = i * roadHeight + roadHeight / 2 - car.getHeight() / 2;

                    g.setColor(car.getColor());
                    g.fillRect(x, y, car.getWidth(), car.getHeight());
                }
            }
        };

        add(racePanel);
        setVisible(true);
    }

    public void update() {
        repaint();
    }
}
