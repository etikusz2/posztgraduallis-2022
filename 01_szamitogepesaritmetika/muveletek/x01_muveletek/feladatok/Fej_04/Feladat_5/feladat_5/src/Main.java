import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami bekér egy karakterláncot, majd kiírja ezt úgy, hogy az első és utolsó karaktert felcseréli.
        // Figyeljünk, hogy minden hosszúságú karakterláncra jól működjön a program.

        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();

        char cElsokarakter = sKarakterlanc.charAt(0);
        char cUtolsokarakter = sKarakterlanc.charAt(sKarakterlanc.length() - 1);

        String sKarakterlancElsokaraterEsUtolsokarakterNelkul = sKarakterlanc.substring(1, sKarakterlanc.length() - 1);

        System.out.println(cUtolsokarakter + sKarakterlancElsokaraterEsUtolsokarakterNelkul + cElsokarakter);
    }
}