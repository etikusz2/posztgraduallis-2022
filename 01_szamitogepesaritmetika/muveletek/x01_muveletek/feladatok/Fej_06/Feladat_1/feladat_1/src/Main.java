import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kérjen be egy számot és írja ki, hogy helló annyiszor.
        // (Emlékezzünk a régi szenvedős megoldásra és értékeljük a haladást.)
        Scanner sc = new Scanner(System.in);
        System.out.println("Mondjon egy szamot: ");
        int iSzam = sc.nextInt();

        for (int i = 0; i < iSzam; i++) {
            System.out.println("hello");
        }
    }
}