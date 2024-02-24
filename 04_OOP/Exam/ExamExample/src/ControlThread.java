import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControlThread extends Thread {
    private MainFrame mainFrame;
    private File file;
    private List<String> texts;
    private int time;


    public ControlThread(File file, MainFrame mainFrame) throws IOException {
        this.file = file;
        this.mainFrame = mainFrame;
        texts = new ArrayList<>();
        time = 2000;
        loadData();
    }

    public void loadData() throws IOException {
        FileReader fr;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                texts.add(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public void run() {
        for (String s : texts) {
            mainFrame.setLabelText(s);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void faster(){
        int newTime = time - 1000;
        if (newTime > 0)
            time = newTime;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void slower(){
        try {
            Thread.sleep(time + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

