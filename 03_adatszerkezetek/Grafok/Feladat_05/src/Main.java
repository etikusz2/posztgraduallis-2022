import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    // Írjon programot ami egy fájlban tárolt szomszédsági mátrix alapján felépít egy irányítatlan gráfot.
    // A fájl formátuma az első sorban a csomópontok száma található 𝑛.
    // Utána egy 𝑛 soros fájlrészben soronként 𝑛 hosszúságban 0-1 sorozat jelöli a szomszédsági mátrixot.
    //a. A fenti fájl alapján építsen fel szomszédsági mátrixszal tárolt gráfot.
    //b. A fenti fájl alapján építsen fel éllistásan tárolt gráfot.

//    private static int[] csomopontok;
//    private static HashMap<Integer, Integer> csomopontokGrafIndexe;
//    private static GrafSzomszMx szomszedok;

    public static void main(String[] args) throws IOException {

        BemenetBeolvasasa("/Users/erzsebetcsillabirtalan/Desktop/posztgradualis2022/posztgraduallis-2022/03_adatszerkezetek/Grafok/Feladat_05/src/bemenet_18_05.txt");
    }

    private static void BemenetBeolvasasa(String path) throws IOException {
        Path bemenetUtja = Paths.get(path);
        File bemenetiFile = bemenetUtja.toFile();
        FileReader fis = new FileReader(bemenetiFile);
        Scanner scBemenet = new Scanner(fis);
        int csomopontokszama = Integer.parseInt(scBemenet.nextLine());
        GrafSzomszMx szmx = new GrafSzomszMx(csomopontokszama);
        GrafEllistas csucsok = new GrafEllistas(csomopontokszama);
        for (int i = 0; i < csomopontokszama; i++) {
            String beolvasottSor = scBemenet.nextLine();
            for (int j = 0; j < csomopontokszama; j++) {
                if (beolvasottSor.charAt(j) == '1') {
                    //a
                    szmx.ElHozzaad(i, j);
                    //b
                    csucsok.ElHozzaad(i, j);
                }
            }
        }
        fis.close();
    }
}

class GrafSzomszMx {
    int[][] szmx;

    public GrafSzomszMx(int n) {
        szmx = new int[n][n];
    }

    public void ElHozzaad(int i, int j) {
        szmx[i][j] = 1;
        szmx[j][i] = 1;
    }

    public int[] Szomszedok(int i) {
        // szomszedok szamanak masolasa
        int iSzomszedainakSzama = 0;
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1)
                ++iSzomszedainakSzama;
        }

        int[] szomszedok = new int[iSzomszedainakSzama];
        int kovetkezoSzomszedHelye = 0;
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1) {
                szomszedok[kovetkezoSzomszedHelye] = j;
                ++kovetkezoSzomszedHelye;
            }
        }
        return szomszedok;
    }

    public HashSet<Integer> SzomszedokHalmaza(int i) {
        HashSet<Integer> szomszedok = new HashSet<>();
        for (int j = 0; j < szmx.length; j++) {
            if (szmx[i][j] == 1) {
                szomszedok.add(j);
            }
        }
        return szomszedok;
    }
}

class GrafEllistas {

    Csucs[] csucsok;

    public GrafEllistas(int n) {
        csucsok = new Csucs[n];
        for (int i = 0; i < csucsok.length; i++) {
            csucsok[i] = new Csucs(i);
        }
    }

    public void ElHozzaad(int i, int j) {
        csucsok[i].SzomszedHozzaadasa(j);
        csucsok[j].SzomszedHozzaadasa(i);
    }

    public int[] Szomszedok(int i) {
        return csucsok[i].Szomszedok();
    }

    public boolean Osszefuggo() {
        return false;
    }
}

class Csucs {
    private int id;

    private ArrayList<ElLeiras> elek = new ArrayList<>();

    public Csucs(int id) {
        this.id = id;
    }

    public void SzomszedHozzaadasa(int ujSzomszedId) {
        for (int i = 0; i < elek.size(); i++) {
            if (elek.get(i).GetElCel() == ujSzomszedId)
                return;
        }

        // valoban uj el
        elek.add(new ElLeiras(ujSzomszedId));
    }

    public int SzomszedokSzama() {
        return this.elek.size();
    }

    public int[] Szomszedok() {
        int[] szomszedok = new int[this.elek.size()];
        for (int j = 0; j < elek.size(); j++) {
            szomszedok[j] = elek.get(j).GetElCel();
        }
        return szomszedok;
    }
}

class ElLeiras {

    private int celCsucs;

    public ElLeiras(int celCsucs) {
        this.celCsucs = celCsucs;
    }

    public int GetElCel() {
        return celCsucs;
    }
}