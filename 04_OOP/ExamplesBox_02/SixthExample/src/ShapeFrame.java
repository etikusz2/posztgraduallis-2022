import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShapeFrame extends Frame {
    private Button refreshButton;
    private Choice shapeChoice;
    private Choice colorChoice;
    private Checkbox filledCheckbox;
    private ShapeCanvas shapeCanvas;
    private Panel controlPanel;

    public ShapeFrame() {
        shapeChoice = new Choice();
        shapeChoice.addItem("Circle");
        shapeChoice.addItem("Square");
        colorChoice = new Choice();
        colorChoice.addItem("red");
        colorChoice.addItem("blue");
        filledCheckbox = new Checkbox("Filled: ");
        refreshButton = new Button("Refresh");
        shapeCanvas = new ShapeCanvas();
        controlPanel = new Panel();
        controlPanel.add(shapeChoice);
        controlPanel.add(colorChoice);
        controlPanel.add(filledCheckbox);
        controlPanel.add(refreshButton);
        this.add(controlPanel, BorderLayout.NORTH);
        this.add(shapeCanvas, BorderLayout.CENTER);
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeCanvas.refresh(shapeChoice.getSelectedItem(), colorChoice.getSelectedItem(), filledCheckbox.getState());
            }
        });
    }

    public static void main(String[] args) {
        ShapeFrame shapeFrame = new ShapeFrame();
        shapeFrame.setBounds(10, 10, 800, 600);
        shapeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        shapeFrame.setVisible(true);
    }
}


