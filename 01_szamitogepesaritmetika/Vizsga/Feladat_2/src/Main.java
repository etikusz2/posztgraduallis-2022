import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] Tomb = new String[100];
        String karakterek = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random r = new Random();
        for (int i = 0; i < Tomb.length; i++) {
            Tomb[i] = String.valueOf(karakterek.charAt(r.nextInt(karakterek.length())));
            System.out.print(Tomb[i]);
        }
        System.out.println();
        ForditottTomb(Tomb);
    }

    public static void ForditottTomb(String[] Tomb) {

        int middle = Tomb.length / 2;

        String temp;
        int j = Tomb.length - 1;

        for (int i = 0; i < middle; i++) {
            temp = Tomb[i];
            Tomb[i] = Tomb[j];
            Tomb[j] = temp;
            j--;
        }

        System.out.println(Arrays.toString(Tomb));
    }
}