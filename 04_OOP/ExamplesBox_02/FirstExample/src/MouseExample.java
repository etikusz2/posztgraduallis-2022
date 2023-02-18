import java.awt.*;
import java.awt.event.*;

public class MouseExample extends Frame {
    private Panel panel;
    private Label label;

    public MouseExample() {
        panel = new Panel();
        label = new Label("Mouse coordinates:");
        add(panel, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse coordinates: " + "X: " + e.getX() + " Y: " + e.getY() + " clicked");
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText("Mouse coordinates: " + "X: " + e.getX() + " Y: " + e.getY() + " moved");
            }
        });
    }

    public static void main(String[] args) {
        MouseExample mouseExample = new MouseExample();
        mouseExample.setBounds(10, 10, 400, 400);

        mouseExample.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mouseExample.setVisible(true);
    }
}
