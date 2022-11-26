public class Main {
    // Írjon  ki  a  képernyőre  n  darab  csillagot.
    // Oldja  meg  kétféleképpen  is.  Iteratív  módon  és  rekurzíó felhasználásával.
    public static void main(String[] args) {
        // iterativan
        int n = 1;
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
        // rekurzivan
        CsillagozasNszer(n);
    }

    private static String CsillagozasNszer(int n) {
        if (n <= 0)
            return "";

        String CsillagozasN_1szer = CsillagozasNszer(n - 1);
        System.out.print("*");
        return "*";
    }
}