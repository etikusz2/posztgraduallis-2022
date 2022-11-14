public class Main {
    static double dSzam = 1.0;

    public static void main(String[] args) {
        // Írjon egy programot amiben deklarál egy globális dupla pontos változót,
        // aminek kezdeti értéke 1. Ezen kívül írjon egy függvényt ami egy parancsot és egy számot vár paraméterként
        // és ezek függvényében értelemszerűen frissíti a globális változó értékét.
        // Az érvényes parancsok: szoroz, oszt, osszead.
        // A main függvényben hívja is meg a függvényt néhány tetszőleges paraméterezéssel.

        System.out.println("A muvelet eredmenye " + Muveletek('+', + 8));
        System.out.println("A muvelet eredmenye " + Muveletek('*', + 56));
        System.out.println("A muvelet eredmenye " + Muveletek('/', + 4));
    }

    private static double Muveletek(char cMuvelet, int iMegadottSzam) {
        if (cMuvelet == '+')
            dSzam = dSzam + iMegadottSzam;
        else if (cMuvelet == '*') {
            dSzam = 1.0;
            dSzam = dSzam * iMegadottSzam;
        } else if (cMuvelet == '/') {
            dSzam = 1.0;
            dSzam = dSzam / iMegadottSzam;
        }
        return dSzam;
    }
}