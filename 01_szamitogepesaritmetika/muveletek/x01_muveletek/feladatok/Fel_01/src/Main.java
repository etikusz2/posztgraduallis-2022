import java.util.Scanner;

public class Main {
    // Olvass be ket egesz szamot es ird ki a kovetkezoket
    //a. osszeguket
    //b. kulonbseguket
    //c. szorzatukat
    //d. maradékos osztási hányadosukat
    //e. osztási maradékukat
    public static void main(String[] args) {
        //Beolvasas

        Scanner sc = new Scanner(System.in);
        System.out.println("Irj ide egy egesz szamot: ");
        int i1 = sc.nextInt();

        System.out.println("Irj meg egyet: ");
        int i2 = sc.nextInt();


        //Muveletek

        int iOsszeadas = i1 + i2;
        System.out.println("A ket szam osszege = " + iOsszeadas);

        int iKivonas = i1 - i2;
        System.out.println("A ket szam kulonbsege = " + iKivonas);

        int iSzorzatuk = i1 * i2;
        System.out.println("A ket szam szorzata = " + iSzorzatuk);

        int iMaradekosOsztasiHanyadosuk = i1 / i2;
        System.out.println("A ket szam osztasi hanyadosa = " + iMaradekosOsztasiHanyadosuk);

        int iOsztasiMaradekuk = i1 % i2;
        System.out.println("A ket szam osztasi maradeka = " + iOsztasiMaradekuk);
    }
}