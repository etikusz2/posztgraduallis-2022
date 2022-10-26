import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kérjen be egy számot és írja ki, hogy helló annyiszor.
        // (Emlékezzünk a régi szenvedős megoldásra és értékeljük a haladást.)

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy szamot: ");
        int iMegadottSzam = sc.nextInt();
        sc.nextLine();
        int i;
        for (i = 0; i < iMegadottSzam; ++i) {
            System.out.println("Hello ");
        }
    }
}