public class Main {
    public static void main(String[] args) {
        Halmaz h1 = new Halmaz();
        Halmaz h2 = new Halmaz();
        h1.Elemhozzaad("Alma");
        System.out.println("A h1 halmaz " + h1.Ures_e());
        h2.Elemhozzaad("Geza");
        h2.Elemhozzaad("Geza");
        h2.Elemhozzaad("Auto");
        h1.Elemhozzaad("Auto");
        h2.Elemhozzaad("Iskola");
        h1.Elemhozzaad("Elemer");
        System.out.println("A h1 elemeinek szama = " + h1.Meret());
        System.out.println("A h2 elmeinek szama = " + h2.Meret());
        Halmaz h1Egyesitveh2 = h1.Egyetsit(h2);
        System.out.println("A h1 es h2 halmazok egyesitett halmaza: " + h1Egyesitveh2);
        Halmaz h1minh2 = h1.Kivonas(h2);
        System.out.println("A h1 es h2 halmazok kulonbsege: " + h1minh2);
        Halmaz h1Metszeth2 = h1.Metszet(h2);
        System.out.println("A h1 es h2 halmazok metszete: " + h1Metszeth2);
    }
}

class Halmaz {
    //tagvaltozok
    // private Set<String> TaroltErtekek;
   private String[] TaroltErtekek;

    //konstruktor
//     public Halmaz() {
//          TaroltErtekek = new Set<String>() {
//              @Override
//              public int size() {
//                  return 0;
//              }
//
//              @Override
//              public boolean isEmpty() {
//                  return false;
//              }
//
//              @Override
//              public boolean contains(Object o) {
//                  return false;
//              }
//
//              @Override
//              public Iterator<String> iterator() {
//                  return null;
//              }
//
//              @Override
//              public Object[] toArray() {
//                  return new Object[0];
//              }
//
//              @Override
//              public <T> T[] toArray(T[] a) {
//                  return null;
//              }
//
//              @Override
//              public boolean add(String s) {
//                  return false;
//              }
//
//              @Override
//              public boolean remove(Object o) {
//                  return false;
//              }
//
//              @Override
//              public boolean containsAll(Collection<?> c) {
//                  return false;
//              }
//
//              @Override
//              public boolean addAll(Collection<? extends String> c) {
//                  return false;
//              }
//
//              @Override
//              public boolean retainAll(Collection<?> c) {
//                  return false;
//              }
//
//              @Override
//              public boolean removeAll(Collection<?> c) {
//                  return false;
//              }
//
//              @Override
//              public void clear() {
//
//              }
//          }
    public Halmaz() {
        TaroltErtekek = new String[0];
    }
    public boolean Elemhozzaad (String karakterlanc){
        if (Tartalmazza_e(karakterlanc))
            return false;
        // O(1)
        String[] ujTaroltErtekek = new String[this.TaroltErtekek.length + 1];
        // O(n)
        for (int i = 0; i < this.TaroltErtekek.length; i++) {
            ujTaroltErtekek[i] = this.TaroltErtekek[i];
        }
        // O(1)
        ujTaroltErtekek[ujTaroltErtekek.length - 1] = karakterlanc;
        this.TaroltErtekek = ujTaroltErtekek;
        return true;
    }
    public  boolean Elemkivetele (String karakterlanc){
        if (!Tartalmazza_e(karakterlanc))
            return false;

        String[] ujTaroltElemek = new String[TaroltErtekek.length - 1];
        boolean atugrottukeMarAkivevendot = false;
        for (int i = 0; i < TaroltErtekek.length; i++) {
            if (TaroltErtekek[i].equals(karakterlanc)) {
                atugrottukeMarAkivevendot = true;
                continue;
            }

            if (!atugrottukeMarAkivevendot)
                ujTaroltElemek[i] = TaroltErtekek[i];
            else
                ujTaroltElemek[i - 1] = TaroltErtekek[i];
        }
        TaroltErtekek = ujTaroltElemek;
        return true;
    }
    public int Meret(){
        return TaroltErtekek.length;
    }
    public boolean Ures_e(){
        return Meret() == 0;
    }
    public void Urites(){
        String[] halmaz = new String[0];
    }
    public Halmaz Egyetsit(Halmaz halmaz){
        Halmaz EgyesitettHalmaz = new Halmaz();
        for (int i = 0; i < this.TaroltErtekek.length; i++) {
            EgyesitettHalmaz.Elemhozzaad(this.TaroltErtekek[i]);
        }
        for (int i = 0; i < halmaz.TaroltErtekek.length; i++) {
            EgyesitettHalmaz.Elemhozzaad(halmaz.TaroltErtekek[i]);
        }
        return EgyesitettHalmaz;
    }
    public Halmaz Metszet(Halmaz halmaz){
        Halmaz Halmazokmetszete = new Halmaz();
        for (int i = 0; i < this.TaroltErtekek.length; i++) {
            for (int j = 0; j < halmaz.TaroltErtekek.length; j++) {
                if (this.TaroltErtekek[i].equals(halmaz.TaroltErtekek[j]))
                    Halmazokmetszete.Elemhozzaad(this.TaroltErtekek[i]);
            }
        }
        return Halmazokmetszete;
    }
    public Halmaz Kivonas(Halmaz kivonando_halmaz){
        Halmaz Halmazokkulonbsege = new Halmaz();
        for (int i = 0; i < this.TaroltErtekek.length; i++) {
            Halmazokkulonbsege.Elemhozzaad(this.TaroltErtekek[i]);
        }
        for (int i = 0; i < kivonando_halmaz.TaroltErtekek.length; i++) {
            Halmazokkulonbsege.Elemkivetele(kivonando_halmaz.TaroltErtekek[i]);
        }
        return Halmazokkulonbsege;
    }
    public boolean Tartalmazza_e(String karakterlanc){
        for (int i = 0; i < TaroltErtekek.length; i++) {
            if (TaroltErtekek[i].equals(karakterlanc))
                return true;
        }
        return false;
    }
}
