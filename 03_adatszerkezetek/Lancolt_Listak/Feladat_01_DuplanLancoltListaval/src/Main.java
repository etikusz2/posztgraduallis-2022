public class Main {
    public static void main(String[] args) {

        DuplanLancoltLista lista = new DuplanLancoltLista();

        lista.ElejereBeszur(2); // 2
        lista.ElejereBeszur(-5); // -5 2
        lista.ElejereBeszur(7); // -5 7 2
        lista.PoziciorolTorol(1); // 0
        lista.AdottPozicionErtekadas(0, 0);
        lista.AdottPozicionErtekadas(1, 1);
        lista.AdottPozicionErtekadas(2, 2); // 0 1 2

        lista.PoziciorolTorol(1); // 0
        System.out.println("A lista elso eleme: " + lista.AdottPozicioLekerdezese(0));
        lista.ElejerolTorol(); // {}
        System.out.println("A lista hossza: " + lista.Hossz());
    }
}

class Lancszem {
    private Lancszem elozo;
    private Lancszem kovetkezo;
    private int adat;

    public void SetElozo(Lancszem elozo) {
        this.elozo = elozo;
    }

    public Lancszem GetElozo() {
        return this.elozo;
    }

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

class DuplanLancoltLista {
    private Lancszem elso;

    private Lancszem utolso;

    public DuplanLancoltLista() {
        this.elso = null;
        this.utolso = null;
    }

    public int Hossz() {
        return 0;
    }

    public void AdottPozicionErtekadas(int poz, int adat) {

    }

    public int AdottPozicioLekerdezese(int poz) {
        return 0;
    }

    public void ElejerolTorol() {

    }

    public void PoziciorolTorol(int poz) {
        Lancszem torlendo = this.elso;
        for (int i = 0; i < poz; i++) {
            torlendo.GetKovetkezo();
        }

        if (torlendo.GetElozo() != null && torlendo.GetKovetkezo() != null){
            // bent a listaban
            torlendo.GetElozo().SetKovetkezo(torlendo.GetKovetkezo());
            torlendo.GetKovetkezo().SetElozo(torlendo.GetElozo());
        }
        else if (torlendo.GetElozo() == null && torlendo.GetKovetkezo() == null){
            // 1 elem a listában
            this.elso= null;
            this.utolso = null;
        }
        else if (torlendo.GetElozo() == null){
            // torles a lista elejen
            elso.GetKovetkezo().SetElozo(null);
            elso = elso.GetKovetkezo();
        }else {
            // torles a lista vegen
            utolso.GetElozo().SetKovetkezo(null);
            utolso = utolso.GetElozo();
        }



    }

    public void ElejereBeszur(int adat) {
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        if (Ures()) {
            this.elso = ujElem;
            this.utolso = ujElem;
        } else {
            ujElem.SetKovetkezo(this.elso);
            this.elso.SetElozo(ujElem);
            this.elso = ujElem;
        }
    }

    public void VegereBeszur(int adat){
        Lancszem ujElem = new Lancszem();
        ujElem.SetAdat(adat);

        if (Ures()){
            this.elso = ujElem;
            this.utolso = ujElem;
        } else {
            this.utolso.SetKovetkezo(ujElem);
            ujElem.SetElozo(this.utolso);
            this.utolso = ujElem;
        }
    }

    public void PozicioraBeszur(int poz, int adat) {

    }

    public boolean Ures() {
        return this.elso == null;
    }
}