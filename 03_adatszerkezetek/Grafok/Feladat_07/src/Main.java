import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    // Labirintus reprezentációja gráffal (gondoljuk végig, hogy szomszédsági mátrixszal
    // vagy éllistásan érdemes ebben a feladatban dolgozni).
    // A szöveges fájl az első sorában két számot tartalmaz szóközzel elválasztva,
    // ami a labirintus méretét jelzi 𝑛,𝑚. Utána 𝑛 darab sor található, mindegyikben 𝑚 hosszú karakterláncok vannak.
    // A ‘ ’-el jelölt részek járhatóak, az ’x’-el jelölt részen fal van.
    // A fájl végén ismét két szám van egy sorban, ami az induló pozíció koordinátáit jelöli (bal felső sarok a 0,0).
    //Írjon programot ami a bemeneti fájlt beolvasva a labirintust egy gráffal reprezentálja,
    // majd a megkeres egy kivezető utat a labirintusból. A fájl végén két szám van egy sorban, ami az induló
    //pozíció koordinátáit jelöli (bal felső sarok a 0,0). Használjon vermet és mélységi bejárást a megoldáshoz.
    private static HashSet<Integer> LehetsegesUtvonalPontok;
    private static GrafSzomszMx LabirintusPontjai;
    public static void main(String[] args) throws IOException {
        BemenetBeolvasasa("/Users/erzsebetcsillabirtalan/Desktop/" +
                "posztgradualis2022/posztgraduallis-2022/03_adatszerkezetek/Grafok/Feladat_07/src/bemenet_18_07.txt");

    }
    private static void BemenetBeolvasasa(String path) throws IOException {
        Path bemenetUtja = Paths.get(path);
        File bemenetiFile = bemenetUtja.toFile();
        FileReader fis = new FileReader(bemenetiFile);
        Scanner scBemenet = new Scanner(fis);
        int sor = scBemenet.nextInt();
        int oszlop = scBemenet.nextInt();
        scBemenet.nextLine();
        GrafSzomszMx szmx = new GrafSzomszMx(sor, oszlop);
        for (int i = 0; i < sor; i++) {
            String beolvasottSor = scBemenet.nextLine();
            for (int j = 0; j < oszlop; j++) {
                if (beolvasottSor.charAt(j) == ' ') {
                    szmx.ElHozzaad(i, j);
                }
            }
        }
        int StartX = scBemenet.nextInt();
        int StartY = scBemenet.nextInt();
        fis.close();
    }
}
class GrafSzomszMx {
    int[][] szmx;

    public GrafSzomszMx(int n, int m) {
        szmx = new int[n][m];
    }

    public void ElHozzaad(int i, int j) {
        szmx[i][j] = 1;
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
    public void KiutKeresesALabirintusbol() {
        Stack<int [][]> feldolgozandoCsomopontok = new Stack<>();
        HashSet<int [][]> marFeldogozottCsomopontok = new HashSet<>();


    }
}
class IntVerem {

    LancoltLista adatokAVeremben;

    public IntVerem() {
        adatokAVeremben = new LancoltLista();
    }

    public void Betesz(int adat) {
        adatokAVeremben.ElejereBeszur(adat);
    }

    public int Kivesz() {
        int elsoErtek = adatokAVeremben.AdottPozicioLekerdezese(0);
        adatokAVeremben.ElejerolTorol();
        return  elsoErtek;
    }

    public boolean Ures() {
        return adatokAVeremben.Hossz() == 0;
    }

    public int Kukucska() {
        return adatokAVeremben.AdottPozicioLekerdezese(0);
    }
}
class Lancszem {
    private Lancszem kovetkezo;
    private int adat;

    public void SetKovetkezo(Lancszem kovetkezo) {
        this.kovetkezo = kovetkezo;
    }

    public Lancszem GetKovetkezo() {
        return this.kovetkezo;
    }

    public void SetAdat(int adat) {
        this.adat = adat;
    }

    public int GetAdat() {
        return adat;
    }
}

class LancoltLista {
    private Lancszem elso;

    private Lancszem utolso;

    public LancoltLista() {
        this.elso = null;
        this.utolso = null;
    }

    public int Hossz() {
        Lancszem aktualisLancszem = this.elso;
        int elemszam = 0;
        while (aktualisLancszem != null) {
            ++elemszam;
            aktualisLancszem = aktualisLancszem.GetKovetkezo();
        }
        return elemszam;
    }

    public void AdottPozicionErtekadas(int poz, int adat) {
        Lancszem adottPozicionLevoSzem = this.elso;
        for (int i = 0; i < poz; i++) {
            adottPozicionLevoSzem = adottPozicionLevoSzem.GetKovetkezo();
        }
        adottPozicionLevoSzem.SetAdat(adat);
    }

    public int AdottPozicioLekerdezese(int poz) {
        Lancszem adottPozicionLevoSzem = this.elso;
        for (int i = 0; i < poz; i++) {
            adottPozicionLevoSzem = adottPozicionLevoSzem.GetKovetkezo();
        }
        return adottPozicionLevoSzem.GetAdat();
    }

    public void ElejerolTorol() {
        this.elso = this.elso.GetKovetkezo();
        if (this.elso == null)
            this.utolso = null;
    }

    public void PoziciorolTorol(int poz) {
        if (poz == 0) {
            ElejerolTorol();
            return;
        }

        Lancszem adottPozicioElottiSzem = this.elso;
        for (int i = 0; i < poz - 1; i++) {
            adottPozicioElottiSzem = adottPozicioElottiSzem.GetKovetkezo();
        }
        adottPozicioElottiSzem.SetKovetkezo(adottPozicioElottiSzem.GetKovetkezo().GetKovetkezo());

        // ha a lista vegerol toroltunk
        if (adottPozicioElottiSzem.GetKovetkezo().GetKovetkezo() == null){
            this.utolso = adottPozicioElottiSzem;
        }
    }

    public void ElejereBeszur(int adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        ujElem.SetKovetkezo(this.elso);
        this.elso = ujElem;

        // ures listabol 1 elemu lista
        if (ujElem.GetKovetkezo() == null){
            this.utolso = ujElem;
        }
    }

    public void VegereBeszur(int adat) {
        if (this.Hossz() == 0)
        {
            ElejereBeszur(adat);
            return;
        }

        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        this.utolso.SetKovetkezo(ujElem);
        this.utolso = ujElem;
    }

    public void PozicioraBeszur(int poz, int adat) {
        if (poz == 0) {
            ElejereBeszur(adat);
        } else {
            Lancszem ujElem = new Lancszem();
            ujElem.SetAdat(adat);

            // utolso elem a pozicio elott
            Lancszem beszurandoElotti = this.elso;
            for (int i = 1; i < poz; i++) {
                beszurandoElotti = beszurandoElotti.GetKovetkezo();
            }

            ujElem.SetKovetkezo(beszurandoElotti.GetKovetkezo());
            beszurandoElotti.SetKovetkezo(ujElem);

            // ha a lista vegere szurtunk, az utolsot is allitani kell
            if (ujElem.GetKovetkezo() == null){
                this.utolso = ujElem;
            }
        }
    }
}