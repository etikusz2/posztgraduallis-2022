import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // Írjon  egy  programot  ami  bemenetként  egy  zárójelekből  álló  karaktersorozatot  kap  (olvassuk fájlból),
    // majd erről eldönti, hogy helyesen van-e zárójelezve a sorozat vagy sem.
    // Pl.: (({})[()()](())) helyes.
    public static void main(String[] args) {
        String karakterlanc = "(({})[()()](()))";
        if (AZarojelekEgyensuybanVannak(karakterlanc))
            System.out.println("A karaktersorozat helyesen van zarojelezve");
        else
            System.out.println("A sorozat hibas");
    }

    private static boolean AZarojelekEgyensuybanVannak(String karakterlanc) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < karakterlanc.length(); i++) {
            char VizsgalandoKaeakter = karakterlanc.charAt(i);

            if (VizsgalandoKaeakter == '(' || VizsgalandoKaeakter == '[' || VizsgalandoKaeakter == '{') {
                stack.push(VizsgalandoKaeakter);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char check;
            switch (VizsgalandoKaeakter) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}

class CharSor {
    LancoltLista adatokASorban;

    public CharSor() {
        adatokASorban = new LancoltLista();
    }

    public void SorbaAll(char adat) {
        adatokASorban.VegereBeszur(adat);
    }

    public int Sorelhagy() {
        int elsoErtek = adatokASorban.AdottPozicioLekerdezese(0);
        adatokASorban.ElejerolTorol();
        return elsoErtek;
    }

    public boolean Ures() {
        return adatokASorban.Hossz() == 0;
    }

    public int Kukucska() {
        return adatokASorban.AdottPozicioLekerdezese(0);
    }
}

class CharVerem {

    LancoltLista adatokAVeremben;

    public CharVerem() {
        adatokAVeremben = new LancoltLista();
    }

    public void Betesz(char adat) {
        adatokAVeremben.ElejereBeszur(adat);
    }

    public int Kivesz() {
        int elsoErtek = adatokAVeremben.AdottPozicioLekerdezese(0);
        adatokAVeremben.ElejerolTorol();
        return elsoErtek;
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
    private char adat;

    public void SetKovetkezo(Lancszem kovetkezo) {
        this.kovetkezo = kovetkezo;
    }

    public Lancszem GetKovetkezo() {
        return this.kovetkezo;
    }

    public void SetAdat(char adat) {
        this.adat = adat;
    }

    public char GetAdat() {
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

    public void AdottPozicionErtekadas(int poz, char adat) {
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
        if (adottPozicioElottiSzem.GetKovetkezo().GetKovetkezo() == null) {
            this.utolso = adottPozicioElottiSzem;
        }
    }

    public void ElejereBeszur(char adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        ujElem.SetKovetkezo(this.elso);
        this.elso = ujElem;

        // ures listabol 1 elemu lista
        if (ujElem.GetKovetkezo() == null) {
            this.utolso = ujElem;
        }
    }

    public void VegereBeszur(char adat) {
        if (this.Hossz() == 0) {
            ElejereBeszur(adat);
            return;
        }

        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        this.utolso.SetKovetkezo(ujElem);
        this.utolso = ujElem;
    }

    public void PozicioraBeszur(int poz, char adat) {
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
            if (ujElem.GetKovetkezo() == null) {
                this.utolso = ujElem;
            }
        }
    }
}