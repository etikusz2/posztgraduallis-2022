import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kérjen be egy karakterláncot. Majd ahány karakter van ebben (pl. alma esetén 4, kiskutya esetén 8),
        // annyiszor írja ki az első karaktert (pl. alma esetén aaaa, kiskutya esetén kkkkkkkk).

        Scanner sc = new Scanner(System.in);
        System.out.println("Irjon be egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();
        char cElsoKarater = sKarakterlanc.charAt(0);
        for (int i = 0; i < sKarakterlanc.length(); i++) {
            System.out.print(cElsoKarater);
        }
    }
}