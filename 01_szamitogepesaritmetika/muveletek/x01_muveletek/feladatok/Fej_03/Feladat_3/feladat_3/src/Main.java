import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Írj programot amiben a felhasnzálónak lehetősége van megadni,
        // hogy egy kör sugarát vagy átmérőjét szeretné megadni.
        // Ezek után kérd be a választott adatot, majd számold ki a kör területét és írd ki.

        Scanner sc = new Scanner(System.in);
        System.out.println("Onnek lehetosege megadni a kor sugarat(Sugar)" +
                " vagy atmerojet(Atmero) es mi kiszamoljuk a teruletet: ");
        String sSugarVagyAtmero = sc.nextLine();

        if (sSugarVagyAtmero.equals("Sugar")) {
            System.out.println("Akkor kerem adja a sugarhosszt (cm): ");
            double dSugar = sc.nextDouble();
            System.out.println(dSugar + " egységnyi sugarú kör területe (cm^2): " + Math.pow(dSugar, 2) * Math.PI);
        } else if (sSugarVagyAtmero.equals("Atmero")) {
            System.out.println("Akkor kerem adja a atmerohosszt (cm): ");
            double dAtmero = sc.nextDouble();
            System.out.println(dAtmero + " egységnyi sugarú kör területe (cm^2): " + Math.pow(dAtmero / 2, 2) * Math.PI);
        } else {
            System.out.println("On helytelen parancsot adott meg. Probalja ujra!");
        }
    }
}