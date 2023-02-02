import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fajlolvaso = new FileInputStream(Paths.get(args[0]).toFile());
        ObjectInputStream ois = new ObjectInputStream(fajlolvaso);
        int elsodimenzio = fajlolvaso.read();
        double[][] Tomb = new double[elsodimenzio][];
        for (int i = 0; i < elsodimenzio; i++) {
            int beolvasottsor = fajlolvaso.read();
            for (int j = 0; j < beolvasottsor; j++) {
                Tomb[i][j] = fajlolvaso.available();
            }
        }
        String karakterlanc = fajlolvaso.toString();
        ois.close();
        fajlolvaso.close();
    }

    Path ujfajlutja = Paths.get("Karakterlanc");
    File ujfile = new File(ujfajlutja.toUri());
    FileWriter fw = new FileWriter(ujfile);

}