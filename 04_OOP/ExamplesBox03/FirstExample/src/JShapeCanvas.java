import javax.swing.*;
import java.awt.*;

public class JShapeCanvas extends JPanel {
    private String shape;
    private Color color;
    private boolean filled;
    private int zoom;

    public JShapeCanvas() {
        this.shape = "Circle";
        this.color = Color.WHITE;
        this.filled = false;
        this.zoom = 50;
        setBackground(Color.CYAN);
    }

    public void refresh(String shape, Color color, boolean filled, int zoom) {
        this.shape = shape;
        this.color = color;
        this.filled = filled;
        this.zoom = zoom;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(zoom * 12, zoom * 12);
    }

    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        gr.setColor(color);
        switch (shape) {
            case "Circle":
                if (filled) {
                    gr.fillOval(getWidth() / 2 - zoom * 4, getHeight() / 2 - zoom * 4, zoom * 8, zoom * 8);
                } else {
                    gr.drawOval(getWidth() / 2 - zoom * 4, getHeight() / 2 - zoom * 4, zoom * 8, zoom * 8);
                }
                break;
            case "Square":
                if (filled) {
                    gr.fillRect(getWidth() / 2 - zoom * 4, getHeight() / 2 - zoom * 4, zoom * 8, zoom * 8);
                } else {
                    gr.drawRect(getWidth() / 2 - zoom * 4, getHeight() / 2 - zoom * 4, zoom * 8, zoom * 8);
                }
                break;
        }
    }
}

