public class Main {
    public static void main(String[] args) {
        Ugroiskola.HozzaAd(egylabas);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(egylabas);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(egylabas);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(terpeszes);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(egylabas);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(terpeszes);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
        Ugroiskola.HozzaAd(egylabas);
        System.out.println("Az ugroiskola aktualis hossza " + Ugroiskola.Hossza + " meter " + " es szelessege "
                + Ugroiskola.Szelessege + " meter ");
    }
}

class Ugroiskola {
    public static int Szelessege;
    public static int Hossza;
    private Ugroiskola negyzet;

    public void setNegyzet(Ugroiskola negyzet) {
        this.negyzet = negyzet;

    }

    public static void HozzaAd(String adat) {

    }

    public static int Hossza(int hossza) {
        return 0;
    }

    public static int Szelesege(int szelessege) {
        return 0;
    }
}

class Lancszem {
    private Lancszem kovetkezo;
    private String adat;
    private Lancszem egylabas;
    private Lancszem terpeszes;

    public void SetKovetkezo(Lancszem kovetkezo) {
        this.kovetkezo = kovetkezo;
        if (kovetkezo.equals(egylabas))
            this.kovetkezo = egylabas;
        else
            this.kovetkezo = terpeszes;
    }

    public Lancszem GetKovetkezo() {
        return this.kovetkezo;
    }

    public void SetAdat(String adat) {
        this.adat = adat;
    }

    public String GetAdat() {
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

    public void AdottPozicionErtekadas(int poz, String adat) {
        Lancszem adottPozicionLevoSzem = this.elso;
        for (int i = 0; i < poz; i++) {
            adottPozicionLevoSzem = adottPozicionLevoSzem.GetKovetkezo();
        }
        adottPozicionLevoSzem.SetAdat(adat);
    }

    public String AdottPozicioLekerdezese(int poz) {
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

    public void ElejereBeszur(String adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        ujElem.SetKovetkezo(this.elso);
        this.elso = ujElem;

        // ures listabol 1 elemu lista
        if (ujElem.GetKovetkezo() == null) {
            this.utolso = ujElem;
        }
    }

    public void VegereBeszur(String adat) {
        if (this.Hossz() == 0) {
            ElejereBeszur(adat);
            return;
        }

        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        this.utolso.SetKovetkezo(ujElem);
        this.utolso = ujElem;
    }

}