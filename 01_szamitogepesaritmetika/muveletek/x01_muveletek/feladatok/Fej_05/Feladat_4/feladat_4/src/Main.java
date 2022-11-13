import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami bekeri négy autó adatait (márka, szín, rendszám).
        // Feltételezhetted, hogy a megadott adatok mindig értelmesek, ezt nem kelle ellenőrizni.
        // Tárold az adatokat tömbök tömbjeként, úgy, hogy az első dimenzióban az autókat indexeljük,
        // a másodikban pedig az adataikat. Beolvasás után írd is ki őket rendszám szerinti ABC sorrendben.

        Scanner sc = new Scanner(System.in);
        String[][] AutokAdatai = new String[3][];
        String[] marka = new String[3];
        String[] szin = new String[3];
        String[] rendszam = new String[3];
        for (int beolvasandoMarkaSorszama = 0; beolvasandoMarkaSorszama < 4; beolvasandoMarkaSorszama++) {
            System.out.println("Add meg az " + (beolvasandoMarkaSorszama + 1) + ". auto marka nevet: ");
            marka[beolvasandoMarkaSorszama] = sc.nextLine();
        }
        for (int beolvasandoSzinSorszama = 0; beolvasandoSzinSorszama < 4; beolvasandoSzinSorszama++) {
            System.out.println("Add meg az " + (beolvasandoSzinSorszama + 1) + ". auto szinet: ");
            szin[beolvasandoSzinSorszama] = sc.nextLine();
        }
        for (int beolvasandoRendszamaSorszama = 0; beolvasandoRendszamaSorszama < 4; beolvasandoRendszamaSorszama++) {
            System.out.println("Add meg az " + (beolvasandoRendszamaSorszama + 1) + ". auto rendszamat: ");
            rendszam[beolvasandoRendszamaSorszama] = sc.nextLine();
        }
        System.out.println(Arrays.deepToString(AutokAdatai));
    }
}