import java.awt.*;

public class ShapeCanvas extends Canvas {
    private String shape;
    private String color;
    private boolean filled;

    public ShapeCanvas(){
        shape = "Circle";
        color = "red";
        filled = false;
        setBackground(Color.CYAN);
    }

    public void refresh(String shape, String color, boolean filled){
        this.shape = shape;
        this.color = color;
        this.filled = filled;
        repaint();
    }

    public void paint(Graphics graphics){
        switch (color){
            case "red":
                graphics.setColor(Color.RED);
                break;
            case "blue":
                graphics.setColor(Color.BLUE);
                break;
        }
        switch (shape){
            case "Circle":
                if(filled){
                    graphics.fillOval(getWidth() / 2 -100, getHeight() / 2 - 100, 200, 200);
                }
                else {
                    graphics.drawOval(getWidth() / 2 -100, getHeight() / 2 - 100, 200, 200);
                }
                break;
            case "Square":
                if(filled){
                    graphics.fillRect(getWidth() / 2 -100, getHeight() / 2 - 100, 200, 200);
                }
                else {
                    graphics.drawRect(getWidth() / 2 -100, getHeight() / 2 - 100, 200, 200);
                }
                break;
        }
    }
}
