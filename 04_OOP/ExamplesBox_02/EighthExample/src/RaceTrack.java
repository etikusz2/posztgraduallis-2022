import javax.swing.*;
import java.awt.*;

public class RaceTrack extends JPanel {
    private Car[] cars;
    public RaceTrack(){
        setBackground(Color.CYAN);
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        gr.setColor(Color.RED);
        for (int i = 0; i < cars.length; i++) {
            gr.fillRect(cars[i].getX(), i * 20, 20, 10);
        }
        gr.setColor(Color.BLACK);
        gr.drawLine(780, 0, 780, 1024);
        gr.setColor(Color.WHITE);
        gr.drawLine(781, 0, 781, 1024);
        gr.setColor(Color.BLACK);
        gr.drawLine(782, 0, 782, 1024);
        gr.setColor(Color.WHITE);
        gr.drawLine(783, 0, 783, 1024);
        gr.setColor(Color.BLACK);
        gr.drawLine(784, 0, 784, 1024);
    }
}
