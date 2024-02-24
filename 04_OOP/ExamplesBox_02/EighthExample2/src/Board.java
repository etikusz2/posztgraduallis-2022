import car.Car;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Board extends JPanel {

    private final List<Car> cars;

    public Board(List<Car> cars) {
        this.cars = cars;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            g.setColor(car.getColor());
            g.fillRect((int) car.getX(), (int) car.getY(), 40, 20);
        }
    }
}
