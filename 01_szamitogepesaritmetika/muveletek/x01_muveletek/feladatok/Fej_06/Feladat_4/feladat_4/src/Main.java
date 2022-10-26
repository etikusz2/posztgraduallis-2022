import java.util.Scanner;

public class Main {
    // Rendes palindrom teszt: Írjon programot amely beolvas egy karakterláncot és arról eldönti,
    // hogy palindróm-e (egy karakterlánc akkor palindróm, ha visszafelé olvasva is ugyan az mint előre,
    // pl: Rád rohan a hordár). A kis- és nagybetűk ne jelentsenek különbséget, valamint a szóközök se számítsanak.
    //Olyan megoldást adjon, amiben nem használ csak egy karakterláncot, az eredeti bemenetet
    //(újabb karakterláncokba való átalakítás nélkül oldja meg a feladatot).

    private static String szoveg = "Anni, a Pápa inna!";
    public static void main(String[] args) {
        boolean palindrom = PalindromEASzoveg();

        if (palindrom)
            System.out.println("Palindorm a: " + szoveg);
        else
            System.out.println("Nem palindorm a: " + szoveg);
    }

    private static boolean PalindromEASzoveg(){
        String sKarakterlancKisbetuvel = szoveg.toLowerCase();
        int iKarakterPozicioAzElsofeleben = 0;
        int iKarakterPozicioAHatsofeleben = szoveg.length() - 1;

        boolean palindrom = true;
        while (iKarakterPozicioAzElsofeleben < iKarakterPozicioAHatsofeleben){
            if (palindromsagSzempontjabolErdektelenKarakter(sKarakterlancKisbetuvel.charAt(iKarakterPozicioAzElsofeleben))){
                iKarakterPozicioAzElsofeleben++;
                continue;
            }
            if (palindromsagSzempontjabolErdektelenKarakter(sKarakterlancKisbetuvel.charAt(iKarakterPozicioAHatsofeleben))){
                iKarakterPozicioAHatsofeleben--;
                continue;
            }
            if (sKarakterlancKisbetuvel.charAt(iKarakterPozicioAzElsofeleben) != sKarakterlancKisbetuvel.charAt(iKarakterPozicioAHatsofeleben)){
                palindrom = false;
                break;
            } else {
                ++iKarakterPozicioAzElsofeleben;
                --iKarakterPozicioAHatsofeleben;
            }
        }
    return palindrom;
    }

    private static boolean palindromsagSzempontjabolErdektelenKarakter(char c) {
        String nemErdekesKarakterek = " .?!,";
        return nemErdekesKarakterek.indexOf(c) >= 0;
    }
}