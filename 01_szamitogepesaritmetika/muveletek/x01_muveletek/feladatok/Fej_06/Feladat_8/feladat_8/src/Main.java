import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami karakterláncokat kér be addig amígy *-ot nem kap,
        // majd kiírja a leghoszabb megadott karakterlánc hosszát.
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerem irjon be karakterlancokat(*-al kilep a program): ");
        String sKarakterlanc = sc.nextLine();
        int iLeghosszabb = 0;
        do {
            if (iLeghosszabb < sKarakterlanc.length()) {
                iLeghosszabb = sKarakterlanc.length();
            }
            while (sKarakterlanc.compareTo("*") == 0) ;
        }
        System.out.println("A leghosszabb karakterlanc " + sKarakterlanc + " hossza = " +sKarakterlanc.length());
    }
}