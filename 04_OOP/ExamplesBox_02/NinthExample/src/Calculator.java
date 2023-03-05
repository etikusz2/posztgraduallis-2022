import java.awt.*;
import java.awt.event.*;

public class Calculator extends WindowAdapter implements ActionListener {
   private Frame f;
   private Label textArea;
   private Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, badd, bsub, bmult, bdiv, bmod, bcalc, bclr, bpts, bneg, bback;
   private double opResult, num1, num2, check;

    public Calculator() {
        f = new Frame("Simple Calculator");
        textArea = new Label();
        textArea.setBackground(Color.CYAN);
        textArea.setBounds(50, 50, 260, 60);
        b1 = new Button("1");
        b1.setBounds(50, 340, 50, 50);
        b2 = new Button("2");
        b2.setBounds(120, 340, 50, 50);
        b3 = new Button("3");
        b3.setBounds(190, 340, 50, 50);
        b4 = new Button("4");
        b4.setBounds(50, 270, 50, 50);
        b5 = new Button("5");
        b5.setBounds(120, 270, 50, 50);
        b6 = new Button("6");
        b6.setBounds(190, 270, 50, 50);
        b7 = new Button("7");
        b7.setBounds(50, 200, 50, 50);
        b8 = new Button("8");
        b8.setBounds(120, 200, 50, 50);
        b9 = new Button("9");
        b9.setBounds(190, 200, 50, 50);
        b0 = new Button("0");
        b0.setBounds(120, 410, 50, 50);
        bneg = new Button("+/-");
        bneg.setBounds(50, 410, 50, 50);
        bpts = new Button(".");
        bpts.setBounds(190, 410, 50, 50);
        bback = new Button("back");
        bback.setBounds(120, 130, 50, 50);
        badd = new Button("+");
        badd.setBounds(260, 130, 50, 50);
        bsub = new Button("-");
        bsub.setBounds(260, 200, 50, 50);
        bmult = new Button("*");
        bmult.setBounds(260, 270, 50, 50);
        bdiv = new Button("/");
        bdiv.setBounds(260, 340, 50, 50);
        bmod = new Button("%");
        bmod.setBounds(190, 130, 50, 50);
        bcalc = new Button("=");
        bcalc.setBounds(245, 410, 65, 50);
        bclr = new Button("Clear");
        bclr.setBounds(50, 130, 65, 50);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bpts.addActionListener(this);
        bneg.addActionListener(this);
        bback.addActionListener(this);
        badd.addActionListener(this);
        bsub.addActionListener(this);
        bmult.addActionListener(this);
        bdiv.addActionListener(this);
        bmod.addActionListener(this);
        bcalc.addActionListener(this);
        bclr.addActionListener(this);
        f.addWindowListener((WindowListener) this);
        f.add(textArea);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(b0);
        f.add(badd);
        f.add(bsub);
        f.add(bmod);
        f.add(bmult);
        f.add(bdiv);
        f.add(bmod);
        f.add(bcalc);
        f.add(bclr);
        f.add(bpts);
        f.add(bneg);
        f.add(bback);
        f.setSize(360, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        String command, textFromTextArea;
        if (e.getSource() == b1) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "1";
            textArea.setText(command);
        }
        if (e.getSource() == b2) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "2";
            textArea.setText(command);
        }
        if (e.getSource() == b3) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "3";
            textArea.setText(command);
        }
        if (e.getSource() == b4) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "4";
            textArea.setText(command);
        }
        if (e.getSource() == b5) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "5";
            textArea.setText(command);
        }
        if (e.getSource() == b6) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "6";
            textArea.setText(command);
        }
        if (e.getSource() == b7) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "7";
            textArea.setText(command);
        }
        if (e.getSource() == b8) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "8";
            textArea.setText(command);
        }
        if (e.getSource() == b9) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "9";
            textArea.setText(command);
        }
        if (e.getSource() == b0) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + "0";
            textArea.setText(command);
        }

        if (e.getSource() == bpts) {
            textFromTextArea = textArea.getText();
            command = textFromTextArea + ".";
            textArea.setText(command);
        }
        if (e.getSource() == bneg) {
            textFromTextArea = textArea.getText();
            command = "-" + textFromTextArea;
            textArea.setText(command);
        }

        if (e.getSource() == bback) {
            textFromTextArea = textArea.getText();
            try {
                command = textFromTextArea.substring(0, textFromTextArea.length() - 1);
            } catch (StringIndexOutOfBoundsException f) {
                return;
            }
            textArea.setText(command);
        }

        if (e.getSource() == badd) {
            try {
                num1 = Double.parseDouble(textArea.getText());
            } catch (NumberFormatException f) {
                textArea.setText("Invalid Format");
                return;
            }
            command = "";
            textArea.setText(command);
            check = 1;
        }
        if (e.getSource() == bsub) {
            try {
                num1 = Double.parseDouble(textArea.getText());
            } catch (NumberFormatException f) {
                textArea.setText("Invalid Format");
                return;
            }
            command = "";
            textArea.setText(command);
            check = 2;
        }
        if (e.getSource() == bmult) {
            try {
                num1 = Double.parseDouble(textArea.getText());
            } catch (NumberFormatException f) {
                textArea.setText("Invalid Format");
                return;
            }
            command = "";
            textArea.setText(command);
            check = 3;
        }
        if (e.getSource() == bdiv) {
            try {
                num1 = Double.parseDouble(textArea.getText());
            } catch (NumberFormatException f) {
                textArea.setText("Invalid Format");
                return;
            }
            command = "";
            textArea.setText(command);
            check = 4;
        }
        if (e.getSource() == bmod) {
            try {
                num1 = Double.parseDouble(textArea.getText());
            } catch (NumberFormatException f) {
                textArea.setText("Invalid Format");
                return;
            }
            command = "";
            textArea.setText(command);
            check = 5;
        }

        if (e.getSource() == bcalc) {
            try {
                num2 = Double.parseDouble(textArea.getText());
            } catch (Exception f) {
                textArea.setText("Enter the number firsly!");
                return;
            }
            if (check == 1)
                opResult = num1 + num2;
            if (check == 2)
                opResult = num1 - num2;
            if (check == 3)
                opResult = num1 * num2;
            if (check == 4)
                opResult = num1 / num2;
            if (check == 5)
                opResult = num1 % num2;
            textArea.setText(String.valueOf(opResult));
        }

        if (e.getSource() == bclr) {
            num1 = 0;
            num2 = 0;
            check = 0;
            opResult = 0;
            command = "";
            textArea.setText(command);
        }

    }

    public static void main(String args[]) {
        new Calculator();
    }
}  