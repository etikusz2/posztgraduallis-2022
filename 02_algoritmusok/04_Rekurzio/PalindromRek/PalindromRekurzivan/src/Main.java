import java.util.Scanner;

public class Main {
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adjon meg egy tesztelni kivant szoveget: ");
        String TesztSzoveg = sc.nextLine().toLowerCase();
        if (PalindromE(TesztSzoveg)) {
            System.out.println("A/Az '" + TesztSzoveg + "' egy Palindrom.");
        } else
            System.out.println("A/Az '" + TesztSzoveg + "' nem egy Palindrom.");
    }

    private static Boolean PalindromE(String Szoveg) {
        String FigyelmenkivulhagyhatoKarakterek = " ,.!?";
        if (Szoveg.length() < 2)
            return true;
        boolean SzovegSpecialisKarakterekNelkul = FigyelmenkivulhagyhatoKarakterek.indexOf(Szoveg.charAt(0)) != -1
                || FigyelmenkivulhagyhatoKarakterek.indexOf(Szoveg.charAt(Szoveg.length() - 1)) != -1;
        return SzovegSpecialisKarakterekNelkul || Szoveg.charAt(0) == Szoveg.charAt(Szoveg.length() - 1)
                && PalindromE(Szoveg.substring(1, Szoveg.length() - 1));
    }
}