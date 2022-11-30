import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    //Írjon egy programot ami az első parancssori argumentumaként kapott helyen lévő szöveges fájlból beolvas egy duplapontos számokat tartalmazó kétdimenziós tömböt.
    // Majd ezt a tömböt oszloponként kiírja egy azonos elérési úton, de .bin-re cserélt kiterjesztésű fájlba.
    //A szöveges, olvasandó fájl formátuma: az első sorban szóközzel elválasztva szerpel a tömb mérete. Utána soronként szóközzel elválasztva a tömb sorai.
    //A bináris, írandó fájl formátuma: az első bájtokon a tömb sorainak és oszlopainak száma szerepel egész számként, utána a tömbe elemei oszloponként.
    public static void main(String[] args) throws IOException {
        FileReader beolvasandofajl = new FileReader(Paths.get(args[0]).toFile());
        Scanner FajlOlvaso = new Scanner(beolvasandofajl);
        int sor = FajlOlvaso.nextInt();
        int oszlop = FajlOlvaso.nextInt();
        String beolvasottSor = FajlOlvaso.nextLine();
        double[][] Tomb = new double[sor][oszlop];
        for (int i = 0; i < sor; i++) {
            beolvasottSor = FajlOlvaso.nextLine();
            for (int j = 0; j < oszlop; j++) {
                Tomb[i][j] = beolvasottSor.charAt(j);
            }
        }
        beolvasandofajl.close();

        Path ujbinalisfajlutja = Paths.get(args[1]);
        File ujbinalisfajl = ujbinalisfajlutja.toFile();
        FileOutputStream fos = new FileOutputStream(ujbinalisfajl);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (int i = 0; i < sor; i++) {
            for (int j = 0; j < oszlop; j++) {
                oos.writeDouble(beolvasottSor.charAt(j));
            }
        }
        oos.close();
        fos.close();
    }
}