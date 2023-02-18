import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends Frame implements ActionListener {

    private TextArea textArea;
    private TextField textField;
    private  Button button;

    public ChatWindow(){
        textArea = new TextArea();
        textArea.setEditable(false);
        textField = new TextField();
        button = new Button("Send");
        add(textField, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        button.addActionListener(this);
        textField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.append(textField.getText() + "\n");
        textField.setText("");
        textField.requestFocus();
    }

    public static void main(String[] args) {
        ChatWindow chatWindow = new ChatWindow();
        chatWindow.setBounds(10, 10, 300, 300);
        chatWindow.setVisible(true);
    }
}
