import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JShapeFrame extends JFrame {
    private JPanel contentPanel;
    private JPanel controlPanel;
    private JComboBox shapeComboBox;
    private JSlider zoomSlider;
    private JCheckBox filledBox;
    private JButton drawButton;
    private JShapeCanvas shapeCanvas;
    private JScrollPane scrollPane;
    private JColorChooser colorChooser;

    public JShapeFrame(){
        contentPanel = new JPanel();
        controlPanel = new JPanel();
        shapeComboBox = new JComboBox<>();
        shapeComboBox.addItem("Circle");
        shapeComboBox.addItem("Square");
        zoomSlider = new JSlider();
        filledBox = new JCheckBox("Filled");
        drawButton = new JButton("Draw");
        shapeCanvas = new JShapeCanvas();
        scrollPane = new JScrollPane(shapeCanvas);
        colorChooser = new JColorChooser();
        controlPanel.add(shapeComboBox);
        controlPanel.add(zoomSlider);
        controlPanel.add(filledBox);
        controlPanel.add(drawButton);
        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(controlPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(colorChooser, BorderLayout.SOUTH);
        this.setContentPane(contentPanel);
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeCanvas.refresh((String) shapeComboBox.getSelectedItem(), colorChooser.getColor(), filledBox.isSelected(), zoomSlider.getValue());
                scrollPane.revalidate();
            }
        });
    }

}
