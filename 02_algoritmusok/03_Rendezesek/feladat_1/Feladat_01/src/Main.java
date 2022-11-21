import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    // Írjon egy programot ami az aktuális könyvtárban lévő bemenet.txt fájlból felölt egy karakterlánc tömböt.
    // A fájl első sorában a későbbi sorok száma van, utána soronként egy-egy karakterlánc.
    // a.Rendezze a tömböt buborék rendezéssel.
    // b.Rendezze a tömböt kiválasztásos rendezéssel.
    // c.Rendezze a tömböt beszúrásos rendezéssel.
    // A rendezést a karakterláncok első betűje alapján végezze el.
    public static void main(String[] args) throws FileNotFoundException {
        Path OlvasandofajlUtja = Paths.get("bemenet.txt");
        File Olvasandofajl = OlvasandofajlUtja.toFile();

        FileReader fr = new FileReader(Olvasandofajl);
        Scanner scFajlOlvaso = new Scanner(fr);
        int TombMerete = scFajlOlvaso.nextInt();
        String[] Tomb = new String[TombMerete];
        for (int i = 0; i < TombMerete; i++) {
            Tomb[i] = scFajlOlvaso.next();
            //System.out.println(Tomb[i]);
        }
        //a
        BuborekosRendezes(Tomb);
        System.out.println("A tomb rendezese kivalasztasos rendezes utan: ");
        for (int i = 0; i < TombMerete; i++) {
            System.out.println(Tomb[i]);
        }

        //b
        KivalasztasosRendezes(Tomb);
        System.out.println("A tomb rendezese kivalasztasos rendezes utan: ");
        for (int i = 0; i < TombMerete; i++) {
            System.out.println(Tomb[i]);
        }

        //c
        BeszurasosRendezes(Tomb);
        System.out.println("A tomb rendezese beszurasos rendezes utan: ");
        for (int i = 0; i < TombMerete; i++) {
            System.out.println(Tomb[i]);
        }

    }

    private static void BuborekosRendezes(String[] Tomb) {
        boolean voltEVegrehajtottCsereAzUtolsoCiklusban;
        int utolsoRendezettPozicio = Tomb.length - 1;
        do {
            voltEVegrehajtottCsereAzUtolsoCiklusban = false;
            for (int i = 0; i < utolsoRendezettPozicio; i++) {
                if (Tomb[i].charAt(0) > Tomb[i + 1].charAt(0)) {
                    voltEVegrehajtottCsereAzUtolsoCiklusban = true;
                    String csere = Tomb[i];
                    Tomb[i] = Tomb[i + 1];
                    Tomb[i + 1] = csere;
                }
            }
            utolsoRendezettPozicio--;
        } while (voltEVegrehajtottCsereAzUtolsoCiklusban);
    }

    private static void KivalasztasosRendezes(String[] Tomb) {
        for (int kivalasztotthely = 0; kivalasztotthely < Tomb.length - 1; kivalasztotthely++) {
            int aktualisanABCsorrendbenLegelolLevoKarakter = kivalasztotthely;
            for (int i = kivalasztotthely + 1; i < Tomb.length; i++) {
                if (Tomb[i].charAt(0) < Tomb[kivalasztotthely].charAt(0)) {
                    aktualisanABCsorrendbenLegelolLevoKarakter = i;
                }
            }
            if (aktualisanABCsorrendbenLegelolLevoKarakter != kivalasztotthely) {
                String csere = Tomb[aktualisanABCsorrendbenLegelolLevoKarakter];
                Tomb[aktualisanABCsorrendbenLegelolLevoKarakter] = Tomb[kivalasztotthely];
                Tomb[kivalasztotthely] = csere;
            }
        }
    }

    private static void BeszurasosRendezes(String[] Tomb) {
        for (int ElsoNemRendezettKarakterlancHelye = 0; ElsoNemRendezettKarakterlancHelye < Tomb.length; ElsoNemRendezettKarakterlancHelye++) {
            int RendezniKivantKarakterlancHelye = ElsoNemRendezettKarakterlancHelye;
            String RendezniKivantKarakterlanc = Tomb[RendezniKivantKarakterlancHelye];
            while (RendezniKivantKarakterlancHelye > 0
                    && Tomb[RendezniKivantKarakterlancHelye - 1].charAt(0) > RendezniKivantKarakterlanc.charAt(0)) {
                Tomb[RendezniKivantKarakterlancHelye] = Tomb[RendezniKivantKarakterlancHelye - 1];
                RendezniKivantKarakterlancHelye--;
            }
            Tomb[RendezniKivantKarakterlancHelye] = String.valueOf(RendezniKivantKarakterlanc);
        }
    }
}