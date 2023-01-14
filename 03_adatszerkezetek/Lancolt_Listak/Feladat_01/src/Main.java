public class Main {
    public static void main(String[] args) {

        LancoltLista lista = new LancoltLista();

        lista.ElejereBeszur(2); // 2
        lista.ElejereBeszur(-5); // -5 2
        lista.PozicioraBeszur(1, 7); // -5 7 2
        lista.AdottPozicionErtekadas(0, 0);
        lista.AdottPozicionErtekadas(1, 1);
        lista.AdottPozicionErtekadas(2, 2); // 0 1 2
        lista.AdottPozicioLekerdezese(1);
        lista.PoziciorolTorol(0); // 1 2
        lista.PoziciorolTorol(1); // 1
        System.out.println("A lista elso eleme: " + lista.AdottPozicioLekerdezese(0));
        lista.ElejerolTorol(); // {}
        System.out.println("A lista hossza: " + lista.Hossz());
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

    public LancoltLista() {
        this.elso = null;
    }

    public int Hossz() {
        Lancszem aktualisLancszem = this.elso;
        int LancHossza = 0;
        while (aktualisLancszem != null) {
            LancHossza++;
            aktualisLancszem = aktualisLancszem.GetKovetkezo();
        }
        return LancHossza;
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
    }

    public void PoziciorolTorol(int poz) {
        if (poz == 0) {
            ElejerolTorol();
            return;
        }
        Lancszem TorlendoElemElotti = this.elso;

        for (int i = 1; i < poz - 1; i++) {
            TorlendoElemElotti = TorlendoElemElotti.GetKovetkezo();
        }

        TorlendoElemElotti.SetKovetkezo(TorlendoElemElotti.GetKovetkezo().GetKovetkezo());
    }

    public void ElejereBeszur(int adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        ujElem.SetKovetkezo(this.elso);
        this.elso = ujElem;
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
        }
    }
}