import java.util.Scanner;

public class Main {
    // Egy karakterláncon karakterenként végig haladva
    // (mintha egy karakterfolyam lenne, és nem állna rendelkezésre az egész) dolgozza azt fel.
    // A feldolgozás eredménye legyen egy karakterlánc tömb,
    // amibe a bemeneti karakterlánc a parancssori argumentumok darabolási szabályai szerint van felvágva
    // (szóközök mentén darabolva, de ”-ek közötti részeket egyben tartva).
    //Pl.: Alma elment aludni mert “nagyon fáradt” volt -> {“Alma”, “elment”, “aludni”, “mert”, “nagyon fáradt”, “volt”}.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Irjon be egy karakterlancot:");
        String karakterlanc = sc.nextLine();
        String[] karakterlancTombosive = karakterlanc.split((" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
        for (String s : karakterlancTombosive) {
            System.out.println(s);
        }
    }
}