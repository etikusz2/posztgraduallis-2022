import java.awt.*;
import java.awt.event.*;

public class MyCanvas2 extends Canvas {
    private Image image;

    private Graphics graphics;

    public MyCanvas2() {
        setBackground(Color.CYAN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                graphics.fillOval(e.getX() - 10, e.getY() - 10, 20, 20);
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = createImage(getWidth(), getHeight());
            graphics = image.getGraphics();
            graphics.setColor(Color.GREEN);
        }
        g.drawImage(image, 10, 10, null);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(10, 10, 800, 600);
        frame.add(new MyCanvas2(), BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        frame.setVisible(true);
    }
}
