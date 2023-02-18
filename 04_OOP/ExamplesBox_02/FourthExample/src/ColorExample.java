import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class ColorExample extends Frame {
    private Panel[] panels;
    private Random random;

    public ColorExample(int n){
        panels = new Panel[n];
        random = new Random();
        setLayout(new GridLayout(1, n));
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new Panel();
            panels[i].setBackground(new Color(random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)));
            panels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((Panel)e.getSource()).setBackground(new Color(random.nextInt(255),
                            random.nextInt(255),
                            random.nextInt(255)));
                }
            });
            add(panels[i]);
        }
    }
    public static void main(String[] args) {
        ColorExample mouseExample = new ColorExample(10);
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
