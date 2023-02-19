import java.util.Scanner;

public class Main {
    // Készítsünk egy osztályt törtek reprezentációjára,
    // és az osztályon belüli metódusok formájában implementáljuk az alapműveleteket (összeadás, kivonás, szorzás, osztás),
    // illetve az ezek elvégzéséhez szükséges segédműveleteket.
    // Készítsünk egy programot, amelyben szemléltetjük osztályunk működését.
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the numerator for fraction 1: ");
        int n1 = reader.nextInt();
        System.out.print("Enter the denominator for fraction 1: ");
        int d1 = reader.nextInt();
        System.out.print("Enter the numerator for fraction 2: ");
        int n2 = reader.nextInt();
        System.out.print("Enter the denominator for fraction 2: ");
        int d2 = reader.nextInt();
        int n = 0, d = 0;
        FractionalNumbersOperation f1 = new FractionalNumbersOperation(n1, d1);
        FractionalNumbersOperation f2 = new FractionalNumbersOperation(n2, d2);
        FractionalNumbersOperation f3 = new FractionalNumbersOperation(n, d);

        int option;
        System.out.println("Select the corresponding number for the desired operation:");
        System.out.println(" 1.  Addition \n 2.  Subtraction \n 3. Multiply \n 4. Divison ");
        option = scan.nextInt();
        if (option == 1) {
            f3 = f1.add(f2);

        }
        if (option == 2) {
            f3 = f1.sub(f2);

        }
        if (option == 3) {
            f3 = f1.multiply(f2);

        }
        if (option == 4) {
            f3 = f1.division(f2);

        }
        System.out.println("The result is " + f3);
    }
}

