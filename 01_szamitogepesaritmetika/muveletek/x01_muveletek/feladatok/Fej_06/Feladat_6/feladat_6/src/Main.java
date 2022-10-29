import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Irj egy programot ami bekér két karakterláncot, majd kiírja,
        // hogy a második karakterlánc hánszor szerepel az elsőben. Ezt kétféleképpen is számolja meg:
        //i. Átfedésekkel: pl: a „abrabrabra”-ban 3-szor szerepel az „abra”, ha átfedéseket megengedünk.
        //ii. Átfedések nélkül: pl: a „abrabrabra”-ban 2-szor szerepel az „abra”, ha átfedéseket nem engedünk meg.
        Scanner sc = new Scanner(System.in);
        System.out.println("Kerem irjon be egy karakterlancot");
        String sKarakterlanc1 = sc.nextLine();
        System.out.println("Adjon meg egy masodikat is: ");
        String sKarakterlanc2 = sc.nextLine();

        // i

        int iAMasodikHanyszorSzerepelAzElsoben = 0;
        int iUtolsoVizsgaltKarakter = 0;

        while (iUtolsoVizsgaltKarakter != -1) {
            iUtolsoVizsgaltKarakter = sKarakterlanc1.indexOf(sKarakterlanc2, iUtolsoVizsgaltKarakter);

            if (iUtolsoVizsgaltKarakter != -1) {
                iAMasodikHanyszorSzerepelAzElsoben++;
                iUtolsoVizsgaltKarakter += sKarakterlanc2.length();
            }
        }

        System.out.println("A/ Az " + sKarakterlanc2 + " " + iAMasodikHanyszorSzerepelAzElsoben + "-szer/szor szerepel a/ az " + sKarakterlanc1 + "-ban/ben.");

        // ii

        int iKarakterlanc1Hossza = sKarakterlanc1.length();
        int iKarakterlanc2Hossza = sKarakterlanc2.length();

        // iKarakterlanc2PoziciojaKarakterlanc1ben= -1 ha nincs talalat, ellenben >=0
        int iKarakterlanc2PoziciojaKarakterlanc1ben = sKarakterlanc1.indexOf(sKarakterlanc2), i = iKarakterlanc2PoziciojaKarakterlanc1ben + 1, szamlalo = (iKarakterlanc2PoziciojaKarakterlanc1ben >= 0) ? 1 : 0;

        while (iKarakterlanc2PoziciojaKarakterlanc1ben != -1 && i <= (iKarakterlanc1Hossza - iKarakterlanc2Hossza)) {
            iKarakterlanc2PoziciojaKarakterlanc1ben = sKarakterlanc1.substring(i, iKarakterlanc1Hossza).indexOf(sKarakterlanc2);
            szamlalo = (iKarakterlanc2PoziciojaKarakterlanc1ben >= 0) ? szamlalo + 1 : szamlalo;
            i = i + iKarakterlanc2PoziciojaKarakterlanc1ben + 1;
        }
        System.out.println("Ha az atfedesek is megengedettek " + szamlalo + "-szer/szor szerepel a/ az " + sKarakterlanc2 + " szolanc a/ az " + sKarakterlanc1 + " szolancban");
    }
}