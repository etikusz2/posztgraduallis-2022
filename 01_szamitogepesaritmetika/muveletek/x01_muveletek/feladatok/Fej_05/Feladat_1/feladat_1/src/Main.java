import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Írj egy programot, ami beolvas 3 keresztnevet
        //  (feltételezhető, hogy amit beír a felhasználó, az keresztnév), majd ezeket fordított sorrendben kiírja.
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerem adjon meg harom nevet: ");
        String sNev1 = sc.nextLine();
        String sNev2 = sc.nextLine();
        String sNev3 = sc.nextLine();

        System.out.println("A nevek forditott sorrendben; " + sNev3 + ", " + sNev2 + ", " + sNev1);
    }
}