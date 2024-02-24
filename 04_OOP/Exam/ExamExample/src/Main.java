import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file;
        if (args.length != 1) {
            file = new File("/Users/erzsebetcsillabirtalan/Desktop/posztgradualis2022/posztgraduallis-2022/04_OOP/Exam/ExamExample/src/data");
        } else {
            file = new File(args[0]);
        }

        if (!file.exists() || !file.canRead()) {
            System.out.println("IO Error");
            System.exit(1);
        }

        MainFrame frame = new MainFrame(file);
        frame.setBounds(10, 10, 200, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}