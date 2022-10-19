import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj programot ami beolvas egy egész, majd eldönti, hogy az alábbi esetek közül melyik áll fenn:
        //a. a szám páratlan
        //b. a szám páros és osztható néggyel, de nem osztható nyolccal
        //c. a szám páros és osztható nyolccal és néggyel is
        //d. a szám páros de nem osztható sem nyolccal sem néggyel
        //e. valami más féle szám

        Scanner sc = new Scanner(System.in);
        System.out.println("Irj be egy egesz szamot: ");
        int iSzam = sc.nextInt();
        boolean iSzamParosEsOszthatoNeggyelDeNyolccalNem = (iSzam % 2 == 0 & iSzam % 4 == 0 & iSzam % 8 != 0);
        boolean iSzamParosEsOszthatoNeggyelEsNyolccal = (iSzam % 2 == 0 & iSzam % 4 == 0 & iSzam % 8 == 0);
        boolean iSzamParosDeNemOszthatoSemNeggyelSemNyolccal = (iSzam % 2 == 0 & iSzam % 4 != 0 & iSzam % 8 != 0);

        if (iSzam % 2 != 0) {
            System.out.println("A megadott szam paratlan.");
        } else if (iSzamParosEsOszthatoNeggyelDeNyolccalNem) {
            System.out.println("A megadott szam paros, oszthato 4-el, de 8-al nem.");
        } else if (iSzamParosEsOszthatoNeggyelEsNyolccal) {
            System.out.println("A megadott szam paros, oszthato 4-el es 8-al is");
        } else if (iSzamParosDeNemOszthatoSemNeggyelSemNyolccal) {
            System.out.println("A megadott szam paros, de nem oszthato 4-el es 8-al sem. ");
        } else {
            System.out.println("Az megadott szam kulonleges");
        }
    }
}