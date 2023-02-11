public class Main {

    public static void main(String[] args) {

        DuplanLancoltLista dll = new DuplanLancoltLista();

        dll.VegereBeszur("Utolsó");
        dll.ElejereBeszur("Második");
        dll.ElejereBeszur("ElsŐ");

        dll.AdottPoziciorolTorol(1);
    }
}

class DuplanLancoltLista {
    private ListaElem elso;
    private ListaElem utolso;

    public DuplanLancoltLista() {
        this.elso = null;
        this.utolso = null;
    }

    public void ElejereBeszur(String adat) {
        ListaElem ujElem = new ListaElem();
        ujElem.setAdat(adat);

        if (Ures()) {
            this.elso = ujElem;
            this.utolso = ujElem;
        } else {
            ujElem.setKovetkezo(this.elso);
            this.elso.setElozo(ujElem);
            this.elso = ujElem;
        }
    }

    public void VegereBeszur(String adat) {
        ListaElem ujElem = new ListaElem();
        ujElem.setAdat(adat);

        if (Ures()) {
            this.elso = ujElem;
            this.utolso = ujElem;
        } else {
            this.utolso.setKovetkezo(ujElem);
            ujElem.setElozo(this.utolso);
            this.utolso = ujElem;
        }
    }

    public void AdottPoziciorolTorol(int pos) {
        ListaElem torlendo = this.elso;
        for (int i = 0; i < pos; i++) {
            torlendo.getKovetkezo();
        }

        if (torlendo.getElozo() != null && torlendo.getKovetkezo() != null) {
            torlendo.getElozo().setKovetkezo(torlendo.getKovetkezo());
            torlendo.getKovetkezo().setElozo(torlendo.getElozo());
        } else if (torlendo.getElozo() == null && torlendo.getKovetkezo() == null) {
            this.elso = null;
            this.utolso = null;
        } else if (torlendo.getElozo() == null) {
            elso.getKovetkezo().setElozo(null);
            elso = elso.getKovetkezo();
        } else {
            utolso.getElozo().setKovetkezo(null);
            utolso = utolso.getElozo();
        }
    }

    public boolean Ures() {
        return this.elso == null;
    }
}

class ListaElem {
    private String adat;
    private ListaElem elozo;
    private ListaElem kovetkezo;

    public void setElozo(ListaElem ujElozo) {
        this.elozo = ujElozo;
    }

    public ListaElem getElozo() {
        return elozo;
    }

    public void setKovetkezo(ListaElem ujKovetkezo) {
        this.kovetkezo = ujKovetkezo;
    }

    public ListaElem getKovetkezo() {
        return kovetkezo;
    }

    public void setAdat(String adat) {
        this.adat = adat;
    }
}
