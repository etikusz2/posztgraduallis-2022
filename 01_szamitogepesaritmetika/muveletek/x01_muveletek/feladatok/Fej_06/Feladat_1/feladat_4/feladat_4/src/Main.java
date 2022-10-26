import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Rendes palindrom teszt: Írjon programot amely beolvas egy karakterláncot és
        // arról eldönti, hogy palindróm-e
        // (egy karakterlánc akkor palindróm, ha visszafelé olvasva is ugyan az mint előre,
        // pl: Rád rohan a hordár). A kis- és nagybetűk ne jelentsenek különbséget, valamint a szóközök se számítsanak.
        // Olyan megoldást adjon, amiben nem használ csak egy karakterláncot, az eredeti bemenetet
        //(újabb karakterláncokba való átalakítás nélkül oldja meg a feladatot).

        Scanner sc = new Scanner(System.in);
        System.out.println ("Adjon meg egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();
        boolean bpalindrom = PalindromEAKarakterlanc();
        if (bpalindrom) {
            System.out.println("Palindorm a: " + sKarakterlanc);
        } else {
            System.out.println("Nem palindorm a: " + sKarakterlanc);
        }
    }
    private static boolean PalindromEAKarakterlanc(){


        int iKarakterPoziciojaASzovegElsofeleben = 0;
        int iKarakterPoziciojaASzovegHatsofeleben = sKarakterlanc.length() - 1;

        boolean palindrom = true;
    }
}