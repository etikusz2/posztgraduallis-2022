import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  Egyszerű palindrom teszt: Írjon programot amely beolvas egy karakterláncot és
        //  arról eldönti, hogy az visszafelé olvasva tökéletesen megegyezik-e önmagával.
        Scanner sc = new Scanner(System.in);
        System.out.println("Irjon be egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();


        boolean bASzovegPalindrom = true;
        for (int i = 0;
             i < sKarakterlanc.length() / 2 && bASzovegPalindrom;
             i++) {
            if (sKarakterlanc.charAt(i) != sKarakterlanc.charAt(sKarakterlanc.length() - 1 - i))
                bASzovegPalindrom = false;
        }

        if (bASzovegPalindrom)
            System.out.println("A szoveg palindrom");
        else
            System.out.println("Ez a karakterlanc nem palindrom");
    }
}