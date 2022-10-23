import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot, ami beolvas 3 keresztnevet (feltételezhető, hogy amit beír a felhasználó, az keresztnév),
        // majd ezeket ábécé sorrendben kiírja. Ne használj beépített rendező függvényt.

        Scanner sc = new Scanner(System.in);
        String[] nevek = new String[3];

        System.out.println("Add meg az elso nevet:");
        nevek[0] = sc.nextLine();
        System.out.println("Add meg a masodik nevet:");
        nevek[1] = sc.nextLine();
        System.out.println("Add meg a harmadik nevet:");
        nevek[2] = sc.nextLine();

        if (nevek[0].compareTo(nevek[1]) <= 0 && nevek[1].compareTo(nevek[2]) <= 0){
            System.out.println("A nevek ABC sorrendben: " + nevek[0] + ", " + nevek[1] + ", " + nevek[2]);
        } else if (nevek[0].compareTo(nevek[2]) <= 0 && nevek[2].compareTo(nevek[1]) <= 0) {
            System.out.println("A nevek ABC sorrendben: " + nevek[0] + ", " + nevek[2] + ", " + nevek[1]);
        } else if (nevek[1].compareTo(nevek[0]) <= 0 && nevek[0].compareTo(nevek[2]) <= 0) {
            System.out.println("A nevek ABC sorrendben: " + nevek[1] + ", " + nevek[0] + ", " + nevek[2]);
        } else if ((nevek[1].compareTo(nevek[2]) <= 0 && nevek[2].compareTo(nevek[0]) <= 0)) {
            System.out.println("A nevek ABC sorrendben: " + nevek[1] + ", " + nevek[2] + ", " + nevek[0]);
        } else if ((nevek[2].compareTo(nevek[0]) <= 0 && nevek[0].compareTo(nevek[1]) <= 0)) {
            System.out.println("A nevek ABC sorrendben: " + nevek[2] + ", " + nevek[0] + ", " + nevek[1]);
        } else {
            System.out.println("A nevek ABC sorrendben: " + nevek[2] + ", " + nevek[1] + ", " + nevek[0]);
        }
    }
}