import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceFrame extends JFrame {
    private JButton startButton;
    private RaceTrack raceTrack;
    private JPanel contentPanel;
    private JPanel controlPanel;
    private JTextField numberOfCarsFiled;
    private RaceController raceController;

    public RaceFrame(RaceTrack raceTrack, RaceController raceController){
        this.raceTrack = raceTrack;
        this.raceController = raceController;
        startButton = new JButton("Start");
        controlPanel = new JPanel();
        numberOfCarsFiled = new JTextField();
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        controlPanel.setLayout(new GridLayout(1, 2));
        controlPanel.add(numberOfCarsFiled);
        controlPanel.add(startButton);
        contentPanel.add(controlPanel, BorderLayout.NORTH);
        contentPanel.add(raceTrack, BorderLayout.CENTER);
        this.setContentPane(contentPanel);
        startButton.addActionListener(e -> {
            RaceController.finished = false;
            raceController.initRace(Integer.parseInt(numberOfCarsFiled.getText()));
            raceController.startRace();
        });
    }

}
