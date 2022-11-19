import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    // Irja ki a program prancssoriargumentumaként megkapott könyvtárban lévő összes könyvtár és fájl nevét.
    // Egyszer a könyvtrárakat, utána a fájlokat.
    public static void main(String[] args) {
        Path aktualisKonyvtar = Paths.get(args[0]);

        File aktualisKonyvtarInfo = aktualisKonyvtar.toFile();

        File[] filerendszerBejegyzesek = aktualisKonyvtarInfo.listFiles();

        System.out.println("Konyvtarak nevei: ");
        for (int i = 0; i < filerendszerBejegyzesek.length; i++) {
            if (filerendszerBejegyzesek[i].isDirectory()) {
                System.out.println(filerendszerBejegyzesek[i].getName());
            }
        }

        System.out.println("Fajlok nevei: ");
        for (int i = 0; i < filerendszerBejegyzesek.length; i++) {
            if (filerendszerBejegyzesek[i].isFile()) {
                System.out.println(filerendszerBejegyzesek[i].getName());
            }
        }

    }
}