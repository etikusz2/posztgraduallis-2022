import java.util.Arrays;

public class Main {
    // Írjuk ki egy 𝑛 pozitív egész szám összes összegfelbontását, vagyis az osszes olyan felbontást,
    // amiben pozitív egész számok összegeként előállítható.
    //Pl.: 4= 1 + 1 + 1 + 1 = 1 + 1 + 2 = 1 + 3 = 2 + 2
    //(a 3+1, 1+2+1 és hasnoló kombinációkat ne írjuk ki)
    private static int[] aktualisReszmegoldas;

    public static void main(String[] args) {
        int helyesMegoldasokSzama = 0;
        KezdetiReszmegoldasBeallitasa(4);

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
                    MegoldasKiirasa(helyesMegoldasokSzama, aktualisReszmegoldas);
                } else {
                    // szintlepes
                    ++aktualisSzint;
                    // reszmegoldas specifikalasa
                }
            } else {
                // backtrack
                // szint lepes lefele
                --aktualisSzint;
                aktualisReszmegoldas[aktualisSzint + 1] = 0;
            }
        }
    }

    private static void KezdetiReszmegoldasBeallitasa(int n) {
        aktualisReszmegoldas = new int[n];
    }

    private static boolean TeljesMegoldas(int aktualisSzint) {
        //[1,1,0,0]
        //[1,3,0,0]
        int ElemekOsszege = 0;
        for (int i = 0; i < aktualisReszmegoldas.length; i++) {
            ElemekOsszege = ElemekOsszege + aktualisReszmegoldas[i];
        }
        return ElemekOsszege == aktualisReszmegoldas.length;
    }

    private static boolean EldobandoReszmegoldas(int aktualisSzint) {
        //[1,1,0,0]
        //[1,3,0,0]
        //[1,4,0,0]
        int ElemekOsszege = 0;
        for (int i = 0; i < aktualisReszmegoldas.length; i++) {
            ElemekOsszege = ElemekOsszege + aktualisReszmegoldas[i];
        }
        if (ElemekOsszege > aktualisReszmegoldas.length)
            return true;
//
        if (aktualisSzint > 0 &&
                aktualisReszmegoldas[aktualisSzint - 1] > aktualisReszmegoldas[aktualisSzint])
            return true;
        return false;
    }

    private static boolean SzintenBelulUjReszmegoldas(int aktualisSzint) {
        int ElemekOsszege = 0;
        for (int i = 0; i < aktualisReszmegoldas.length; i++) {
            ElemekOsszege = ElemekOsszege + aktualisReszmegoldas[i];
        }
        if (ElemekOsszege >= aktualisReszmegoldas.length)
            return false;
        aktualisReszmegoldas[aktualisSzint]++;
        return true;
        //[1,1,0,0]   [1,2,0,0]
        //[1,3,0,0]
        //[1,4,0,0]
    }

    private static void MegoldasKiirasa(long megoldasiTippekSzama, int[] megoldasTipp) {
        System.out.print("#" + megoldasiTippekSzama + ": ");
        for (int i = 0; i < aktualisReszmegoldas.length - 1; ++i) {
            System.out.print(aktualisReszmegoldas[i] + " + ");
        }
        System.out.println(aktualisReszmegoldas[aktualisReszmegoldas.length - 1]);
    }
}