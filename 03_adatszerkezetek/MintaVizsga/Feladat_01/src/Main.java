public class Main {

    public static void main(String[] args) {

        SzimplanLancoltLista szll = new SzimplanLancoltLista();

        szll.VegereBeszur("Utolsó");
        szll.ElejereBeszur("Második");
        szll.ElejereBeszur("Első");

        szll.AdottPoziciorolTorol(1);
    }
}

class SzimplanLancoltLista {
    private ListaElem elso;

    public SzimplanLancoltLista() {
        elso = null;
    }

    public void ElejereBeszur(String adat) {
        ListaElem ujElem = new ListaElem();
        ujElem.setAdat(adat);

        ujElem.setKovetkezo(this.elso);
        this.elso = ujElem;
    }

    public void VegereBeszur(String adat) {
        ListaElem ujElem = new ListaElem();
        ujElem.setAdat(adat);
    }

    public void AdottPoziciorolTorol(int pos) {

        ListaElem pozicioElotti = elso;
        for (int i = 0; i < pos - 1; i++) {
            pozicioElotti = pozicioElotti.getKovetkezo();
        }
        pozicioElotti.setKovetkezo(pozicioElotti.getKovetkezo().getKovetkezo());

    }
}

class ListaElem {
    private String adat;
    private ListaElem kovetkezo;


    public void setKovetkezo(ListaElem ujKovetkezo) {
        this.kovetkezo = ujKovetkezo;
    }

    public ListaElem getKovetkezo() {
        return kovetkezo;
    }

    public void setAdat(String adat) {
        this.adat = adat;
    }

    public String getAdat() {
        return adat;
    }
}