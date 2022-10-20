import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kérj be két számot, majd kérd be, hogy számtani vagy mértani középarányost szeretnénk számolni.
        // Számold és írd ki a kért művelet eredméyét.

        Scanner sc = new Scanner(System.in);
        System.out.println("Mondj egy szamot: ");
        double dSzam1 = sc.nextDouble();
        System.out.println("Mondj meg egyet: ");
        double dSzam2 = sc.nextDouble();

        double dSzamtanikozep = (dSzam1 + dSzam2) / 2;
        double dMertanikozep = Math.sqrt(dSzam1 * dSzam2);

        System.out.println("Szamtanikozepet vagy Mertanikozepet szeretnel szamitani? ");
        String sSzamtanikozepetVagyMertanikozepet = sc.next();

        if (sSzamtanikozepetVagyMertanikozepet.equals("Szamtanikozepet")) {
            System.out.println(+dSzam1 + " es " + dSzam2 + " szamtani kozepe = " + dSzamtanikozep);
        } else if (sSzamtanikozepetVagyMertanikozepet.equals("Mertanikozepet")) {
            System.out.println(+dSzam1 + " es " + dSzam2 + " mertani kozepe = " + dMertanikozep);
        } else {
            System.out.println("A rendszer csak a 'Szamtanikozepet', illetve a 'Mertanikozepet' ismeri fel!");
        }
    }
}