import java.util.Arrays;

public class Main {
    // Írjon egy programot, ami egy rekurzív algoritmussal kiszámolja egy tömb elemeinek a háromszög összegét.
    //Egy tömb elemeinek a háromszögösszegét úgy kapjuk meg,
    // hogy a tömb egymás mellett lévő elemeit addig adogatjuk össze, amíg már csak egy elem marad.
    //Pl.: A {1, 2, 3, 4, 5} tömb háromszögösszege 48, mert:
    // [1, 2, 3, 4, 5] -> [3, 5, 7, 9]-> [8, 12, 16]-> [20, 28]->48
    public static void main(String[] args) {
        int[] Tomb = {9, 7, 3, 1, 4};
        HaromszogOsszegSzamitas(Tomb);
    }

    private static void HaromszogOsszegSzamitas(int[] Tomb) {
        if (Tomb.length < 2)
            System.out.print("A tomb haromszog osszege = " + Arrays.stream(Tomb).sum());
        else {
            System.out.print(Arrays.toString(Tomb) + "->");
            int[] KisebbTomb = new int[Tomb.length - 1];
            for (int i = 0; i < Tomb.length - 1; i++) {
                int Osszeg = Tomb[i] + Tomb[i + 1];
                KisebbTomb[i] = Osszeg;
            }
            HaromszogOsszegSzamitas(KisebbTomb);
        }
    }
}