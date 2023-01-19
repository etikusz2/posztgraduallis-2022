public class Main {

    private static int[] aktualisKiralynoElhelyes;

    public static void main(String[] args) {

        int helyesMegoldasokSzama = 0;
        KezdetiReszmegoldadBeallitasa(4);

        // backtracking iterativan
        int aktualisSzint = 0;
        while (aktualisSzint >= 0) {
            boolean azonosSzintenVoltUjKezdemeny = false;
            boolean ujKezdemenyEldobando = false;
            do {
                azonosSzintenVoltUjKezdemeny = SzintenBelulUjReszmegoldas(aktualisSzint);
                if (azonosSzintenVoltUjKezdemeny)
                    ujKezdemenyEldobando = EldobandoReszmegoldas(aktualisSzint);
            } while (azonosSzintenVoltUjKezdemeny && ujKezdemenyEldobando);

            if (!ujKezdemenyEldobando && azonosSzintenVoltUjKezdemeny) {
                if (TeljesMegoldas(aktualisSzint)) {
                    // dolgozzuk
                    ++helyesMegoldasokSzama;
                    MegoldasKiirasa(helyesMegoldasokSzama, aktualisKiralynoElhelyes);
                } else {
                    // szintlepes
                    ++aktualisSzint;
                    // reszmegoldas specifikalasa
                }
            } else {
                // backtrack
                // szint lepes lefele
                --aktualisSzint;
                aktualisKiralynoElhelyes[aktualisSzint + 1] = -1;
            }
        }
    }

    private static void KezdetiReszmegoldadBeallitasa(int n) {
        aktualisKiralynoElhelyes = new int[n];
        for (int i = 0; i < n; i++) {
            aktualisKiralynoElhelyes[i] = -1;
        }
    }

    private static boolean TeljesMegoldas(int aktualisSzint) {
        return aktualisSzint == aktualisKiralynoElhelyes.length - 1;
    }

    private static boolean EldobandoReszmegoldas(int aktualisSzint) {
        // azonos sorban levo utkozest nem kell ellenorizni

        // azonos oszlop ellenorzes
        // a tombben nem lehet ket azonos elem
        // -- rendezzuk, ket egymasmelletti elem ha azonos - O(n log n) + O (n)
        // dupla iteracio
        if (TartalmazAzonosElemet(aktualisKiralynoElhelyes, aktualisSzint))
            return true;

        // atlon utkozes ellenorzese
        boolean vanAtlosUtkozes = false;
        for (int i = 0; i <= aktualisSzint && !vanAtlosUtkozes; i++) {
            for (int j = i + 1; j <= aktualisSzint && !vanAtlosUtkozes; j++) {
                if (Math.abs(aktualisKiralynoElhelyes[i] - aktualisKiralynoElhelyes[j]) == Math.abs(i - j)) {
                    vanAtlosUtkozes = true;
                }
            }
        }
        return vanAtlosUtkozes;
    }

    private static boolean SzintenBelulUjReszmegoldas(int aktualisSzint) {
        if (!(aktualisKiralynoElhelyes[aktualisSzint] < aktualisKiralynoElhelyes.length - 1))
            return false;

        // ha van tovabbi reszmegoldas a szinten, azt be kell allitani
        aktualisKiralynoElhelyes[aktualisSzint]++;

        return true;
    }

    private static void NaivMegoldas() {
        long megoldasiTippekSzama = 0;
        int joMegoldasokSzama = 0;
        int n = 10;
        // össszes megoldás felsorolása
        int[] megoldasTipp = new int[n];

        do {
            // megoldas kiiras
            ++megoldasiTippekSzama;

            // megoldas ellenorzese
            if (JoMegoldas(megoldasTipp)) {
                MegoldasKiirasa(megoldasiTippekSzama, megoldasTipp);
                ++joMegoldasokSzama;
            }

        } while (KovetkezoMegoldasraAllit(megoldasTipp));

        System.out.println("Osszes lehetseges megoldasok szama: " + megoldasiTippekSzama);
        System.out.println("Jo megoldasok szama:" + joMegoldasokSzama);
    }

    private static boolean JoMegoldas(int[] megoldasTipp) {
        // azonos sorban levo utkozest nem kell ellenorizni

        // azonos oszlop ellenorzes
        // a tombben nem lehet ket azonos elem
        // -- rendezzuk, ket egymasmelletti elem ha azonos - O(n log n) + O (n)
        // dupla iteracio
        if (TartalmazAzonosElemet(megoldasTipp, megoldasTipp.length))
            return false;

        // atlon utkozes ellenorzese
        boolean vanAtlosUtkozes = false;
        for (int i = 0; i < megoldasTipp.length && !vanAtlosUtkozes; i++) {
            for (int j = i + 1; j < megoldasTipp.length && !vanAtlosUtkozes; j++) {
                if (Math.abs(megoldasTipp[i] - megoldasTipp[j]) == Math.abs(i - j)) {
                    vanAtlosUtkozes = true;
                }
            }
        }
        return !vanAtlosUtkozes;
    }

    private static boolean TartalmazAzonosElemet(int[] megoldasTipp, int ellenorzesiTartomanyVege) {
        boolean vanAzonosElem = false;
        for (int i = 0; i <= ellenorzesiTartomanyVege; i++) {
            for (int j = i + 1; j <= ellenorzesiTartomanyVege; j++) {
                if (megoldasTipp[i] == megoldasTipp[j]) {
                    vanAzonosElem = true;
                    break;
                }
            }
        }
        return vanAzonosElem;
    }

    private static void MegoldasKiirasa(long megoldasiTippekSzama, int[] megoldasTipp) {
        System.out.print("#" + megoldasiTippekSzama + ": ");
        for (int i = 0; i < megoldasTipp.length; i++) {
            System.out.print(megoldasTipp[i]);
            if (i < megoldasTipp.length - 1)
                System.out.print(", ");
            else
                System.out.println();
        }
    }

    private static boolean KovetkezoMegoldasraAllit(int[] v) {
        // megkeresem az utolso nem n-1 értéket és azt növelemá
        // HF:irjatok at while-ra
        int novelhetoPozicio = v.length - 1;
        for (; novelhetoPozicio >= 0; novelhetoPozicio--) {
            if (v[novelhetoPozicio] != v.length - 1)
                break;
        }

        if (novelhetoPozicio < 0)
            return false;

        v[novelhetoPozicio] = v[novelhetoPozicio] + 1;

        for (int i = novelhetoPozicio + 1; i < v.length; i++) {
            v[i] = 0;
        }

        return true;
    }
}