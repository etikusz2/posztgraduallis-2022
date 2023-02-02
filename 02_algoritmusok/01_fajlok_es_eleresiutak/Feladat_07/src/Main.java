import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    // Írjon egy programot, ami a parancssori argumentumaként kapott fájlból feltölt egy kétdimenziós törtszám tömböt,
    // aminek a második dimenziói változnak.
    // A fájl első sora azt adja meg, hogy a tömb első dimenziója mentén hány elem van.
    // Ez után minden sor egy számmal kezdődik, ami azt mutatja meg,
    // hogy a második dimenzióban a tömb hány elemet tartalmaz abban az elemben.
    // Majd ezek a számok következnek szóközökkel elválasztva.
    public static void main(String[] args) throws FileNotFoundException {
        FileReader beolvasandofajl = new FileReader(Paths.get(args[0]).toFile());
        Scanner FajlOlvaso = new Scanner(beolvasandofajl);
        int sor = FajlOlvaso.nextInt();
        String beolvasottsor = FajlOlvaso.nextLine();
        double [][] Tomb = new double[sor][];
        for (int i = 0; i < sor; i++) {
            beolvasottsor = FajlOlvaso.nextLine();
            for (int j = 1; j < beolvasottsor.charAt(0); j++) {
                Tomb[i][j] = beolvasottsor.charAt(j);
            }
        }
    }
}