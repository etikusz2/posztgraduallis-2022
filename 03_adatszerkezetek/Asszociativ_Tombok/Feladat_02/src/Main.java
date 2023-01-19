import java.util.HashMap;

public class Main {
    // Implementáljon karakterláncokat tartalmazó multihalmaz adatszerkezetet asszociatív tömbökre építve.
    public static void main(String[] args) {

        StringMultihalmaz smh = new StringMultihalmaz();
        smh.HozzaAd("a");
        smh.HozzaAd("a");
        if (smh.ElemMultiplicitasa("a") == 2) {
            System.out.println("Lehet, hogy jól működik az adatszerkezet");
        } else {
            System.out.println("Tuti rossz az adatszerkezet.");
        }
    }
}

class StringMultihalmaz {
    private HashMap<String, Integer> adatok;

    public StringMultihalmaz() {
        adatok = new HashMap<>();
    }

    public void HozzaAd(String elem) {
        if (BenneVan(elem)) {
            // mar benne van
            int aktualisMultiplicitas = this.adatok.get(elem);
            this.adatok.replace(elem, aktualisMultiplicitas + 1);
        } else {
            // uj elem
            this.adatok.put(elem, 1);
        }
    }

    public int Szamossag() {
        return adatok.size();
    }

    public boolean Kivesz(String elem) {
        int aktualisMultiplicitas = this.adatok.get(elem);
        if (!BenneVan(elem)) {
            return false;
        } else if (aktualisMultiplicitas == 0) {
            this.adatok.remove(elem);
            return true;
        }else {
            this.adatok.remove(elem, aktualisMultiplicitas - 1);
            return true;
        }
    }

    public StringMultihalmaz Kivon(StringMultihalmaz kivonando) {
        return new StringMultihalmaz();
    }

    public StringMultihalmaz Egyesit(StringMultihalmaz halmaz) {
        return new StringMultihalmaz();
    }

    public StringMultihalmaz Metszet(StringMultihalmaz metszendo) {
        return new StringMultihalmaz();
    }

    public void Urit() {
        adatok.clear();
    }

    public boolean BenneVan(String elem) {
        return this.adatok.containsKey(elem);
    }

    public boolean uresE() {
        return Szamossag() == 0;
    }

    public String[] Ertekek() {
        return new String[0];
    }

    public int ElemMultiplicitasa(String elem) {
        if (!this.adatok.containsKey(elem))
            return 0;

        return this.adatok.get(elem);
    }
}