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
    // Írjon programot ami egy fájlban tárol éllista alapján felépít egy irányított gráfot.
    // A fájl formátuma az első sorban a csomópontok száma található 𝑛.
    // Utána egy sorban kapcsolatok száma 𝑚, majd 𝑚 sorban soronként két szám szóközzel elválaszta, ami mutatja,
    // hogy melyik két csomópontot kell összekötni.
    //a. A fenti fájl alapján építsen fel szomszédsági mátrixszal tárolt gráfot.
    //b. A fenti fájl alapján építsen fel éllistásan tárolt gráfot.

    private static HashMap<String, Integer> csucsokGrafIndexe;

    private static GrafEllistas csucsKapcsolatok;

    private static GrafSzomszMx szmx;

    public static void main(String[] args) throws IOException {
        BemenetBeolvasasa(args);
    }

    private static void BemenetBeolvasasa(String[] args) throws IOException {
        Path bemenetUtja = Paths.get(args[0]);
        File bemenetiFile = bemenetUtja.toFile();
        FileReader fis = new FileReader(bemenetiFile);
        Scanner scBemenet = new Scanner(fis);
        int n = Integer.parseInt(scBemenet.nextLine());

        szmx = new GrafSzomszMx(n);
        csucsokGrafIndexe = new HashMap<>();
        csucsKapcsolatok = new GrafEllistas(n);
        for (int i = 0; i < n; i++) {
            csucsokGrafIndexe.put(String.valueOf(i), i);
        }
        CsucsKombinaciokBeolvasasa(scBemenet);


        fis.close();
    }

    private static void CsucsKombinaciokBeolvasasa(Scanner scBemenet) {
        int m = Integer.parseInt(scBemenet.nextLine());

        for (int i = 0; i < m; i++) {
            String CsucsKombinacio = scBemenet.nextLine();
            CsucsKombinacioFeldolgozas(CsucsKombinacio);
        }
    }

    private static void CsucsKombinacioFeldolgozas(String Csucskombinacio) {
        String[] nevekAKombinacioban = Csucskombinacio.split(" ");
        for (int j = 0; j < nevekAKombinacioban.length; j++) {
            for (int k = j + 1; k < nevekAKombinacioban.length; k++) {
                String csucs1 = nevekAKombinacioban[j].trim();
                String csucs2 = nevekAKombinacioban[k].trim();
                csucsKapcsolatok.ElHozzaad(csucsokGrafIndexe.get(csucs1),
                        csucsokGrafIndexe.get(csucs2));
                szmx.ElHozzaad(csucsokGrafIndexe.get(csucs1), csucsokGrafIndexe.get(csucs2));
            }
        }
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
        // csucsok[i].SzomszedHozzaadasa(j);
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

    private ArrayList<ElLeiras> elek;

    public Csucs(int id) {
        this.id = id;
        this.elek = new ArrayList<>();
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