import java.util.Scanner;
import org.

public class Main {
    public static void main(String[] args) {
        // Írj egy függvényt ami egy karakterláncot kiegészít adott hosszúságúra.
        // A függvény paraméterként várja a kiegészítendő karakterláncot, a kiegészítéshez használatos karaktert,
        // az elérni kívánt hosszt valamint azt, hogy a karakterlánc elejére vagy végére kerüljenek a kitöltő karakterek.

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();

        String sKiegeszitettKarakterlanc = Kiegeszit(sKarakterlanc, '_', 15, true);

        System.out.println(sKiegeszitettKarakterlanc);
    }

    private static String Kiegeszit(String sKarakterlanc, char cKiegesziteshezHasznaltKarakter, int iKivanthossz,
                                    boolean bEloreVagyAVegere) {
        String sKiegeszitettKarakterlanc = String.format();
        Scanner sc = new Scanner(System.in);
        System.out.println("Milyen karakterrel szeretne kiegesziteni a karakterlancot? ");
        String sKiegesziteshezHasznaltKarakter = sc.nextLine();
        System.out.println("Adja meg a karakterlanc kivant hosszat: ");
        iKivanthossz = sc.nextInt();
        System.out.println("A karakterlanc elejere(e) vagy vegere(v) keruljenek a kitolto karakterek? ");
        bEloreVagyAVegere = sc.hasNext("e");
       if (bEloreVagyAVegere = true){

       }

        return sKiegeszitettKarakterlanc;
    }
}
public class
