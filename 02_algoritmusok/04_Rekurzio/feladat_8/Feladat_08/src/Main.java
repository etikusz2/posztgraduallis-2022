import java.util.Stack;

public class Main {
    // Egy olyan világban mozgunk, ahol a koordináták egész számok.
    // És utazni csak egy fura szabály szerint lehet.
    // Egy (𝑥, 𝑦) koordinátájú pontból csak az (𝑥, 𝑥 + 𝑦) és az (𝑥 + 𝑦, 𝑦) koordinátákra lehet mozogni.
    //Írjon egy függvényt, ami eldönti, egy indulási és egy érkezési koordinátapárról,
    // hogy az érkezési pont elérhető-e az indulási helyről.
    //Pl.: indulási hely (2,10), érkezési hely (26,12) esetén (2, 10) → (2, 12) → (14, 12) → (26, 12)
    // egy megengedett útvonal. Indulási hely (2,10), érkezési hely (15,16) esetén nincs ilyen útvonal.
    // (Bónusz: írja is ki a lépések sorozatát. Visszafelé egyszerűbb, előre kicsit bonyolultabb.)
    public static void main(String[] args) {
        int xIndulas = 2;
        int yIndulas = 10;
        int xErkezes = 26;
        int yErkezes = 12;
        UtvonalKiirasa(xIndulas, yIndulas, xErkezes, yErkezes);
    }

    private static boolean ElerhetoE(int xIndulas, int yIndulas, int xErkezes, int yErkezes) {
        Stack<Integer> xInd = new Stack<Integer>();
        Stack<Integer> yInd = new Stack<Integer>();
        return Utvonal(xIndulas, yIndulas, xErkezes, yErkezes, xInd, yInd);
    }

    static boolean Utvonal(int xIndulas, int yIndulas,
                           int xErkezes, int yErkezes,
                           Stack<Integer> xInd, Stack<Integer> yInd)
    {
        // Base condition
        if (xIndulas > xErkezes || yIndulas > yErkezes) {
            return false;
        }

        // Push current elements
        xInd.add(xIndulas);
        yInd.add(yIndulas);

        // Condition to check whether reach to the
        // Destination or not
        if (xIndulas == xErkezes && yIndulas == yErkezes) {
            LetezoUtvonalKiirasa(xInd, yInd, xInd.size());
            return true;
        }

        // Increment 'x' ordinate of source by (2*x+y)
        // Keeping 'y' constant
        if (Utvonal(xIndulas + yIndulas, yIndulas,
                xErkezes, yErkezes, xInd, yInd))
        {
            return true;
        }

        // Increment 'y' ordinate of source by (2*y+x)
        // Keeping 'x' constant
        if (Utvonal(xIndulas, yIndulas + xIndulas,
                xErkezes, yErkezes, xInd, yInd))
        {
            return true;
        }

        // Pop current elements form stack
        xInd.pop();
        yInd.pop();

        // If no path exists
        return false;
    }

    private static void LetezoUtvonalKiirasa(Stack<Integer> xInd, Stack<Integer> yInd, int utolsolepes) {
        if (xInd.isEmpty() || yInd.isEmpty())
            return;
        int x = xInd.peek();
        int y = yInd.peek();
        LetezoUtvonalKiirasa(xInd, yInd, utolsolepes);
        if (xInd.size() == utolsolepes - 1)
            System.out.println("(" + x + ", " + y + ")");
        else
            System.out.println("(" + x + ", " + y + ")" + " -> ");
    }

    private static void UtvonalKiirasa(int xIndulas, int yIndulas, int xErkezes, int yErkezes) {
        if (!ElerhetoE(xIndulas, yIndulas, xErkezes, yErkezes))
            System.out.println("Nincs ilyen utvonal");
    }
}