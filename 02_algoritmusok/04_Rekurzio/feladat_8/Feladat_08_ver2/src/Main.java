// Java program for printing a path from
// given source to destination

import java.util.*;

class GFG {

    // Function to print the path
    static void printExistPath(Stack<Integer> sx,
                               Stack<Integer> sy, int last) {
        // Base condition
        if (sx.isEmpty() || sy.isEmpty()) {
            return;
        }
        int x = sx.peek();
        int y = sy.peek();

        // Pop stores elements
        sx.pop();
        sy.pop();

        // Recursive call for printing stack
        // In reverse order
        printExistPath(sx, sy, last);
        if (sx.size() == last-4) {

            System.out.print("(" + x + ", " + y + ")");
        } else {
            System.out.print("(" + x + ", " + y + ")->");
        }
    }

    // Function to store the path into
// The stack, if path exist
    static boolean storePath(int srcX, int srcY,
                             int destX, int destY,
                             Stack<Integer> sx, Stack<Integer> sy) {
        // Base condition
        if (srcX > destX || srcY > destY) {
            return false;
        }

        // Push current elements
        sx.add(srcX);
        sy.add(srcY);

        // Condition to check whether reach to the
        // Destination or not
        if (srcX == destX && srcY == destY) {
            printExistPath(sx, sy, sx.size());
            return true;
        }

        // Increment 'x' ordinate of source by (2*x+y)
        // Keeping 'y' constant
        if (storePath((srcX + srcY), srcY,
                destX, destY, sx, sy)) {
            return true;
        }

        // Increment 'y' ordinate of source by (2*y+x)
        // Keeping 'x' constant
        if (storePath(srcX, srcY + srcX,
                destX, destY, sx, sy)) {
            return true;
        }

        // Pop current elements form stack
        sx.pop();
        sy.pop();

        // If no path exists
        return false;
    }

    // Utility function to check whether path exist or not
    static boolean isPathExist(int srcX, int srcY,
                               int destX, int destY) {
        // To store x co-ordinate
        Stack<Integer> sx = new Stack<Integer>();

        // To store y co-ordinate
        Stack<Integer> sy = new Stack<Integer>();

        return storePath(srcX, srcY, destX,
                destY, sx, sy);
    }

    // Function to find the path
    static void printPath(int srcX, int srcY,
                          int destX, int destY) {
        if (!isPathExist(srcX, srcY, destX, destY)) {
            // Print -1, if path doesn't exist
            System.out.print("-1");
        }
    }

    // Driver code
    public static void main(String[] args) {
        int srcX = 2, srcY = 10;

        int destX = 26, destY = 12;

        // Function call
        printPath(srcX, srcY, destX, destY);
    }
}

// This code is contributed by 29AjayKumar
