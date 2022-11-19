import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Írja ki a program aktuális könyvtárában lévő összes könyvtár és fájl nevét.
        // Egyszer a könyvtrárakat, utána a fájlokat.

        Path aktualisKonyvtar = Paths.get("").toAbsolutePath();

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