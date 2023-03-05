import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CounterFrame counterFrame = new CounterFrame();
        counterFrame.setBounds(10, 10, 200,200);
        counterFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        counterFrame.setVisible(true);
    }
}