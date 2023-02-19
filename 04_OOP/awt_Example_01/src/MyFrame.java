import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements ActionListener {

    private Button button1;
    private Button button2;
    private Label label;

    public MyFrame() {
        button1 = new Button("Button 1");
        add(button1, BorderLayout.NORTH);
        button2 = new Button("Button 2");
        add(button2, BorderLayout.SOUTH);
        label = new Label("Label");
        add(label, BorderLayout.CENTER);
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        f.setBounds(10,10, 300, 300);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText(e.getActionCommand());
    }
}