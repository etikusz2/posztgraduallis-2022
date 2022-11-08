import java.util.Scanner;

public class Main {
    // Írj egy programot ami bekér egy karakterláncot,
    // majd törli minden páros helyen álló karakterét és kiírja a képernyőre.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerek egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();
        String sKarakterlancParosKarakterekNelkul = "";

        for (int i = 0; i < sKarakterlanc.length(); i++) {
            if (i % 2 == 1) {
                continue;
            }
            sKarakterlancParosKarakterekNelkul += sKarakterlanc.charAt(i);
        }
        System.out.println("A karakterlanc paros indexu karakterek nelkul: " + sKarakterlancParosKarakterekNelkul);
    }
}