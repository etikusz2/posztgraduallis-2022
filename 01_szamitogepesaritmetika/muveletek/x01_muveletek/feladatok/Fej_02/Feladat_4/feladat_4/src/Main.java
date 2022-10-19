import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Írj egy programot ami beolvas egy tetszőleges egész számot, majd egy 0 és 4 közötti egész számot.
        // Ha a második szám nem 0 és négy közötti, dorongold le a felhasználót.
        //Ezek után írd ki az első szám másodikkal binárisan eltolt értékeit
        // mind a három tanult bináris eltolás operátorral (<<, >>, >>>)

        Scanner sc = new Scanner(System.in);
        System.out.println("Adj meg egy tetszoleges egesz szamot: ");
        int i1 = sc.nextInt();
        System.out.println("Mondj meg egyet 0 es 4 kozott");
        int i2 = sc.nextInt();

        int i1Bsi2 = i1 << i2;
        int i1Jsi2 = i1 >> i2;
        int i1Jjsi2 = i1 >>> i2;

        if (i2 > 0 & i2 < 4) {
            System.out.println("Az elso szam balra eltolva a masodik szammal = " + i1Bsi2);
            System.out.println("Az elso szam jobbra eltolva a masodik szammal = " + i1Jsi2);
            System.out.println("Az elso szam jobbra duplan eltolva a masodik szammal = " + i1Jjsi2);
        } else {
            System.out.println("Nem jo! A masodik szam 0 es 4 kozott legyen");
        }
    }
}