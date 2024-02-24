import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JButton button1;
    private JButton button2;
    private JLabel label;
    private JPanel contentPanel;
    private ControlThread ct;

    public MainFrame(File file) throws IOException {
        button1 = new JButton("slower");
        button2 = new JButton("faster");
        label = new JLabel();
        contentPanel = new JPanel();
        contentPanel.add(button1, BorderLayout.NORTH);
        contentPanel.add(button2, BorderLayout.NORTH);
        contentPanel.add(label,BorderLayout.CENTER);

        this.setContentPane(contentPanel);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ct.slower();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ct.faster();
            }
        });

        ct = new ControlThread(file, this);
        ct.start();
    }

    public void setLabelText(String text){
        label.setText(text);
    }
}
