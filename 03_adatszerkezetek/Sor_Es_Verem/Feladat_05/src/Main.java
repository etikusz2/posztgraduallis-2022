public class Main {
    // Írjon programot ami egy karakterláncról eldönti, hogy palindrom-e (kis és nagybetűk, szóközök nem számítanak).
    // Használjon erre igazán alkalmas adatszerkezetet, majd hasonlítsa össze az első kurzusban adott megoldással.

}

class VeremVaz {
    static char[] Verem;
    static int top = -1;

    static void push(char elenorzendoKarakter) {
        Verem[++top] = elenorzendoKarakter;
    }

    static char pop() {
        return Verem[top--];
    }

    static int isPalindrome(char Karakterlanc[]) {
        int length = Karakterlanc.length;

        Verem = new char[length * 4];

        // Finding the mid
        int i, mid = length / 2;

        for (i = 0; i < mid; i++) {
            push(Karakterlanc[i]);
        }

        if (length % 2 != 0) {
            i++;
        }

        while (i < length) {
            char ele = pop();

            if (ele != Karakterlanc[i])
                return 0;
            i++;
        }

        return 1;
    }

    public static void main(String[] args) {
        char Karakterlanc[] = "gezakekazeg".toCharArray();

        if (isPalindrome(Karakterlanc) == 1) {
            System.out.printf("Palindrom!");
        } else {
            System.out.printf("Nem Palindrom!");
        }
    }
}