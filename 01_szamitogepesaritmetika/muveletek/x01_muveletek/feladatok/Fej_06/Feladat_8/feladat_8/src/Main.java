import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami karakterláncokat kér be addig amígy *-ot nem kap,
        // majd kiírja a leghoszabb megadott karakterlánc hosszát.
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerem irjon be egy karakterlancot(*-al kilep a program): ");
        String sKarakterlanc = sc.nextLine();
        int iLeghosszabb = 0;
        String sLeghosszabblanc = sKarakterlanc;
        while (sKarakterlanc.compareTo("*") != 0) {
            if (iLeghosszabb < sKarakterlanc.length()) {
                iLeghosszabb = sKarakterlanc.length();
                sLeghosszabblanc = sKarakterlanc;
            }
            System.out.println("Adjon egy uj karakterlancot (*-al kilephet): ");
            sKarakterlanc = sc.nextLine();
        }

        System.out.println("Az On altal megadott leghosszabb karakterlanc, " + sLeghosszabblanc + ", hossza = " + sLeghosszabblanc.length() + " karakter");
    }
}