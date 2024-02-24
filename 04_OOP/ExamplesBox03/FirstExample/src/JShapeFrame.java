import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
    private JMenuBar menuBar;
    private JMenu filemenu;
    private JMenuItem loadItem, saveItem;

    public JShapeFrame() {
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        filemenu = new JMenu("File");
        filemenu.add(loadItem);
        filemenu.add(saveItem);
        menuBar = new JMenuBar();
        menuBar.add(filemenu);
        this.setJMenuBar(menuBar);

        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(JShapeFrame.this);
                loadImage(fileChooser.getSelectedFile());
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(JShapeFrame.this);
                saveImage(fileChooser.getSelectedFile());
            }
        });
        
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

    private void saveImage(File file){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write((String) shapeComboBox.getSelectedItem() +"\n");
            bw.write(colorChooser.getColor().getRed() + "\n");
            bw.write(colorChooser.getColor().getGreen() + "\n");
            bw.write(colorChooser.getColor().getBlue() + "\n");
            bw.write(filledBox.isSelected() + "\n");
            bw.write(zoomSlider.getValue() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Save operation failed",
                    "IO Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void loadImage(File file){
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            shapeComboBox.setSelectedItem(br.readLine());
            colorChooser.setColor(new Color(
                    Integer.parseInt(br.readLine()),
                    Integer.parseInt(br.readLine()),
                    Integer.parseInt(br.readLine())
            ));
            filledBox.setSelected(Boolean.parseBoolean(br.readLine()));
            zoomSlider.setValue(Integer.parseInt(br.readLine()));
            shapeCanvas.refresh((String) shapeComboBox.getSelectedItem(), colorChooser.getColor(), filledBox.isSelected(), zoomSlider.getValue());
            scrollPane.revalidate();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Load operation failed",
                    "IO Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
