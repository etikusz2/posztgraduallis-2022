import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args){
        JShapeFrame shapeFrame = new JShapeFrame();
        shapeFrame.setBounds(10, 10, 1024, 768);
        shapeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        shapeFrame.setVisible(true);
    }
}