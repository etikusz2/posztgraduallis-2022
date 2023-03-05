import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener {
    private JButton okButton;
    private JLabel goodLabel, badLabel, textLabel;
    private JTextField answerField;
    private JPanel contentPanel;
    private int goodAnswers;
    private int badAnswers;
    private ControlThread control;

    public MainFrame(File file) throws IOException {
        okButton = new JButton("OK");
        textLabel = new JLabel("Hello");
        goodLabel = new JLabel("0");
        goodLabel.setForeground(Color.GREEN);
        badLabel = new JLabel("0");
        badLabel.setForeground(Color.RED);
        answerField = new JTextField();
        contentPanel = new JPanel();

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(okButton, BorderLayout.SOUTH);
        contentPanel.add(textLabel, BorderLayout.NORTH);
        contentPanel.add(badLabel, BorderLayout.WEST);
        contentPanel.add(goodLabel, BorderLayout.EAST);
        contentPanel.add(answerField, BorderLayout.CENTER);

        this.setContentPane(contentPanel);

        okButton.addActionListener(this);
        answerField.addActionListener(this);

        control = new ControlThread(file, this);
        control.start();
    }

    public void setLabelText(String text) {
        textLabel.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textLabel.getText().equals(answerField.getText())) {
            goodLabel.setText(String.valueOf(goodAnswers++));
        } else {
            badLabel.setText(String.valueOf(badAnswers++));
        }

        if(goodAnswers >=5){
            control.interrupt();
            answerField.setEnabled(false);
            textLabel.setText("Game over!");
        }

        answerField.setText("");
        answerField.requestFocus();
    }

    public int getGoodAnswers() {
        return goodAnswers;
    }
}
