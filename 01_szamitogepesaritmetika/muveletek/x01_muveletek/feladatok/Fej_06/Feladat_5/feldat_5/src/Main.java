import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írjon programot ami addig olvas be karakterláncokat ameddig azt nem adjuk meg neki, hogy Exit.
        // Minden beolvasott karakterláncot írjon is ki azonnal fordítva, de az Exit-et már ne.
        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();
        String sKarakterlancForditva = "";
        while (sKarakterlanc.compareTo("Exit") != 0) {
            for (int i = 0; i < sKarakterlanc.length(); i++) {
                sKarakterlancForditva = sKarakterlanc.charAt(i) + sKarakterlancForditva;
            }
            System.out.println(sKarakterlancForditva);
            sKarakterlancForditva = "";
            System.out.println("Adjon meg egy masik karakterlancot: ");
            sKarakterlanc = sc.nextLine();
        }
    }
}