import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame implements CounterListener{
    private JButton startButton, stopButton, suspendButton, resumeButton;
    private JLabel counterLabel;
    private JPanel contentPane;
    private Counter counter;


    public CounterFrame(){
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        suspendButton = new JButton("Suspend");
        resumeButton = new JButton("Resume");
        counterLabel = new JLabel("0");
        contentPane = new JPanel();
        counter = new Counter(this);
        counter.addCounterListener(this);
        contentPane.add(startButton);
        contentPane.add(stopButton);
        contentPane.add(suspendButton);
        contentPane.add(resumeButton);
        contentPane.add(counterLabel);
        setContentPane(contentPane);
        enableButtons(true, false, false, false);
        counter.addCounterListener(new CounterListener() {
            @Override
            public void counterValueChange(CounterEvent counterEvent) {
                System.out.println(counterEvent.getValue());
            }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.start();
                enableButtons(false, true, false, true);
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.stop();
                enableButtons(true, false, false, false);
            }
        });
        suspendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.suspend();
                enableButtons(false, true, true, false);
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter.resume();
                enableButtons(false, true, false, true);
            }
        });
    }

    public void updateCounterLabel(int value){
        counterLabel.setText(value + "");
    }

    public void enableButtons(boolean start, boolean stop, boolean resume, boolean suspend){
        startButton.setEnabled(start);
        stopButton.setEnabled(stop);
        resumeButton.setEnabled(resume);
        suspendButton.setEnabled(suspend);
    }

    @Override
    public void counterValueChange(CounterEvent counterEvent) {
        updateCounterLabel(counterEvent.getValue());
    }
}
