import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Írjon egy programot ami egy 100 elemű tömböt feltölt véletlen számokkal,
        // majd az utolsó 50 pozíción tárolt elemet egy pozícióval hátrébb tolja,
        // és az utolsó elemet az első eltolt elem eredeti helyére teszi.

        int[] Tomb = new int[100];
        Random r = new Random();
        for (int i = 0; i < Tomb.length; i++) {
            Tomb[i] = r.nextInt();
            System.out.print("Tomb[" + i + "] = " + Tomb[i] + " ");
        }
        System.out.println();
        int csere = Tomb[99];
        for (int i = 99; i > 49; i--) {
            Tomb[i] = Tomb[i-1];
        }
        Tomb[49] = csere;
        for (int i = 0; i < Tomb.length; i++) {
            System.out.print("Tomb[" + i + "] = " + Tomb[i] + " ");
        }
    }
}