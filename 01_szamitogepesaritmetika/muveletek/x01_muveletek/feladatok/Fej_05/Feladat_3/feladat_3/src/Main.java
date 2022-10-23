import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj programot, ami be kér egy számot 1 és 5 között,
        // majd pontosan ennyi keresztnevet kér be és ezeket kiírja fordított sorrendben.

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy szamot 1 es 5 kozott: ");
        int iSzam = sc.nextInt();
        sc.nextLine();

        String [] keresztnevek = new String[iSzam];
        switch (iSzam){
            case 1:
                System.out.println("A nevek forditott sorrendben: " + keresztnevek[0]);
                break;
            case 2:
                System.out.println("A nevek forditott sorrendben: " + keresztnevek[1] + ", " + keresztnevek[0]);
                break;
            case 3:
                System.out.println("A nevek forditott sorrendben: " + keresztnevek[2] + ", " + keresztnevek[1] + ", " + keresztnevek[0]);
                break;
            case 4:
                System.out.println("A nevek forditott sorrendben: " +keresztnevek[3] + keresztnevek[2] + ", " + keresztnevek[1] + ", " + keresztnevek[0]);
        }
    }
}