public class Main {
    // Írjon egy programot, ami kiírja a képernyőre az összes olyan 9 (vagy valamilyen más) hosszú karakterláncot,
    // ami csak 0 és 1 karaktereket tartalmaz, de nincs benne sehol egymást követő 1-es.
    // Számolja is meg a megoldások számát és a megoldások után azt is írja ki, hogy hány megoldás volt.
    public static void main(String[] args) {
        int[] NullaEgyTomb = new int[9];
        Kiiras(NullaEgyTomb, 9);
        System.out.println();
        System.out.println("A lehetseges megoldasok szama = " + KarakterlancSzamlalo(9));
    }

    private static void NullaEgyGenerator(int[] Tomb, int karakterlanchossza, int index) {
        if (index == karakterlanchossza) {
            for (int i = 0; i < karakterlanchossza; i++)
                System.out.print(Tomb[i]);
            System.out.print(" ");

            return;
        } else if (Tomb[index - 1] == 1) {
            Tomb[index] = 0;
            NullaEgyGenerator(Tomb, karakterlanchossza, index + 1);
        } else {
            Tomb[index] = 0;
            NullaEgyGenerator(Tomb, karakterlanchossza, index + 1);
            Tomb[index] = 1;
            NullaEgyGenerator(Tomb, karakterlanchossza, index + 1);
        }
    }

    private static void Kiiras(int[] Tomb, int karakterlanchossza) {
        Tomb[0] = 0;
        NullaEgyGenerator(Tomb, karakterlanchossza, 1);
        Tomb[0] = 1;
        NullaEgyGenerator(Tomb, karakterlanchossza, 1);
    }

    private static int KarakterlancSzamlalo(int n) {
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        return a[n - 1] + b[n - 1];
    }
}
