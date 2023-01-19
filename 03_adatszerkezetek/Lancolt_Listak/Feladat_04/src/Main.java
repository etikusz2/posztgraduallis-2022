public class Main {
    // Írjon olyan függvényt egy láncolt lista típusra,
    // ami két pozíció paramétert kap és a két adott helyen lévő elemet felcseréli a listában.
    public static void main(String[] args) {
        LancoltLista lista = new LancoltLista();

        lista.ElejereBeszur(0); // 0
        lista.PozicioraBeszur(1, 1); // 0, 1
        lista.ElemFelcserel(0, 1); // 1, 0
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

    public void ElemFelcserel (int FelcserelendoElemPoz, int CsereElemPoz) {
        Lancszem FelcserelendoElem = this.elso;
        Lancszem CsereElem = this.elso.GetKovetkezo();
        int LancHossza = Hossz();
        if (FelcserelendoElemPoz != CsereElemPoz && LancHossza > 1){
            for (int i = 0; i <= FelcserelendoElemPoz; i++) {
                FelcserelendoElem = FelcserelendoElem.GetKovetkezo();
                for (int j = 1; j <= CsereElemPoz; j++) {
                    CsereElem = CsereElem.GetKovetkezo();
                }
            }
            CsereElem.SetKovetkezo(FelcserelendoElem.GetKovetkezo());
            FelcserelendoElem.SetKovetkezo(CsereElem.GetKovetkezo());
        }
    }
}