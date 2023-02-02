import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a sor szamat: ");
        int sor = sc.nextInt();
        System.out.println("Adja meg az elem szamat: ");
        int x = sc.nextInt();
        kiiras(sor, x);
    }

    public static void kiiras(int n, int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                System.out.format("%6d", (pascalharomszog(i, j)));
            }
        }
    }

    public static int pascalharomszog(int i, int j) {
        if (j == 0) {
            return 1;
        } else if (j == i) {
            return 1;
        } else {
            return pascalharomszog(i - 1, j - 1) + pascalharomszog(i - 1, j);
        }
    }
}