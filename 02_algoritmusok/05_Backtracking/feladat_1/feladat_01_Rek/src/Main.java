public class Main {
    // Rekurziv backtracking
    // Egy 𝑛 × 𝑛 -es méretű saktábblán írja ki a képernyőre az összes olyan elrendezést,
    // ahol pontosan 𝑛 királynő van és azok nem támadják egymást a sakk szabályai értelmében.
    public static void main(String[] args) {
        int n = 4;

        int[] reszlegesMegoldas = new int[n];

        backtrack(reszlegesMegoldas);
    }

    private static void backtrack(int[] reszlegesMegoldas) {

        if (EldobandoReszmegoldas(reszlegesMegoldas))
            return;

        if (TeljesMegoldas(reszlegesMegoldas))
            MegoldasKiirasa(reszlegesMegoldas);

        int[] kiterjesztettMegoldas = EgySzinttelKiterjeszt(reszlegesMegoldas);
        while (kiterjesztettMegoldas != null) {
            backtrack(kiterjesztettMegoldas);
            kiterjesztettMegoldas = AdottSzintenKovetkezo(kiterjesztettMegoldas);
        }
    }

    private static int[] AdottSzintenKovetkezo(int[] reszlegesMegoldas) {
        // ha van az aktualis szinten tovabbi probalhato megoldas
       int Kovetkezoszinthely = getKovetkezoszintHely(reszlegesMegoldas);
       int kovekezoMegoldas[] = new int[reszlegesMegoldas.length];
        for (int i = 0; i < Kovetkezoszinthely; i++) {
            kovekezoMegoldas[i] = reszlegesMegoldas[i];
        }
        kovekezoMegoldas[Kovetkezoszinthely - 1]++;
        return kovekezoMegoldas;
        //  akkor a kovetkezot allitja elo
        // hanem null
    }

    private static int[] EgySzinttelKiterjeszt(int[] reszlegesMegoldas) {
        // ha lehet kiterjeszteni, akkor egy uj reszmegoldast allit elo
        int KovetkezoszintHely = getKovetkezoszintHely(reszlegesMegoldas);
        if (KovetkezoszintHely == reszlegesMegoldas.length)
            return null;
        int[] kiterjesztett = new int[reszlegesMegoldas.length];
        for (int i = 0; i < KovetkezoszintHely; i++) {
            kiterjesztett [i] = reszlegesMegoldas[i];
        }
        kiterjesztett[KovetkezoszintHely] = 1;
        return kiterjesztett;
        // a kovetkező szint első reszmegoldasaval
        // hanem null
    }

    private static int getKovetkezoszintHely(int[] reszlegesMegoldas) {
        int KovetkezoszintHely = 0;
        for (int i = 0; i < reszlegesMegoldas.length; i++) {
            if (reszlegesMegoldas[KovetkezoszintHely] != 0)
                KovetkezoszintHely = 1;
            else
                break;
        }
        return KovetkezoszintHely;
    }


    private static void MegoldasKiirasa(int[] reszlegesMegoldas) {
       // System.out.print("#" + megoldasiTippekSzama + ": ");
        for (int i = 0; i < reszlegesMegoldas.length; i++) {
            System.out.print(reszlegesMegoldas[i]);
            if (i < reszlegesMegoldas.length - 1)
                System.out.print(", ");
            else
                System.out.println();
        }
    }

    private static boolean TeljesMegoldas(int[] reszlegesMegoldas) {
        return reszlegesMegoldas[reszlegesMegoldas.length -1] != 0;
    }

    private static boolean EldobandoReszmegoldas(int[] reszlegesMegoldas) {
        if (TartalmazAzonosElemet(reszlegesMegoldas))
            return true;

        // atlon utkozes ellenorzese
        boolean vanAtlosUtkozes = false;
        for (int i = 0; i <= reszlegesMegoldas.length - 1 && !vanAtlosUtkozes; i++) {
            for (int j = i + 1; j <= reszlegesMegoldas.length - 1; j++) {
                if (Math.abs(reszlegesMegoldas[i] - reszlegesMegoldas[j]) == Math.abs(i - j)) {
                    vanAtlosUtkozes = true;
                    break;
                }
            }
        }
        return vanAtlosUtkozes;
    }
    private static boolean TartalmazAzonosElemet(int[] megoldasTipp) {
        boolean vanAzonosElem = false;
        for (int i = 0; i <= megoldasTipp.length -1; i++) {
            for (int j = i + 1; j <= megoldasTipp.length -1; j++) {
                if (megoldasTipp[i] == megoldasTipp[j] && megoldasTipp[i] != 0 && megoldasTipp[j] != 0) {
                    vanAzonosElem = true;
                    break;
                }
            }
        }
        return vanAzonosElem;
    }
}