import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleDrawingApplication extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    private JPanel canvas;
    private JButton freeDrawButton, lineDrawButton, clearButton;
    private Point lastCoordinates;
    private String drawingMode;

    public SimpleDrawingApplication() {
        super("Simple Drawing App");
        
        canvas = new JPanel();
        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(this);
        canvas.addMouseMotionListener(this);
        add(canvas, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        freeDrawButton = new JButton("Free draw");
        freeDrawButton.addActionListener(this);
        buttonsPanel.add(freeDrawButton);
        lineDrawButton = new JButton("Draw line");
        lineDrawButton.addActionListener(this);
        buttonsPanel.add(lineDrawButton);
        clearButton = new JButton("Clear All");
        clearButton.addActionListener(this);
        buttonsPanel.add(clearButton);
        add(buttonsPanel, BorderLayout.NORTH);

        lastCoordinates = null;
        drawingMode = null;

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == freeDrawButton) {
            canvas.addMouseListener(this);
            canvas.addMouseMotionListener(this);
            drawingMode = "free";
        } else if (e.getSource() == lineDrawButton) {
            canvas.addMouseListener(this);
            canvas.addMouseMotionListener(this);
            drawingMode = "line";
        } else if (e.getSource() == clearButton) {
            canvas.repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (drawingMode == "line" && lastCoordinates != null) {
            int x1 = lastCoordinates.x;
            int y1 = lastCoordinates.y;
            int x2 = e.getX();
            int y2 = e.getY();
            Graphics g = canvas.getGraphics();
            g.drawLine(x1, y1, x2, y2);
            lastCoordinates = new Point(x2, y2);
        } else {
            lastCoordinates = new Point(e.getX(), e.getY());
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (drawingMode == "free" && lastCoordinates != null) {
            int x1 = lastCoordinates.x;
            int y1 = lastCoordinates.y;
            int x2 = e.getX();
            int y2 = e.getY();
            Graphics g = canvas.getGraphics();
            g.drawLine(x1, y1, x2, y2);
            lastCoordinates = new Point(x2, y2);
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }

    public static void main(String[] args) {
        new SimpleDrawingApplication();
    }
}
