import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Írj egy programot ami bekér egy karakterláncot és az első betű összes előfordulását kicseréli !-re,
        // kétféle képpen. Egyik esetben karakterláncfeldolgozó műveletekkel,
        // a másik esetben egy Java beépített metódus használatával (google a barátod).
        // Ha jól dolgozol, a két megoldás azonos kell legyen.

        Scanner sc = new Scanner(System.in);
        System.out.println("Kerek egy karakterlancot: ");
        String sKarakterlanc = sc.nextLine();

        // Karakterlanc feldolgozo muvelet segitsegevel
        int iKarakterPozicioja = 0;
        char cKicserelendoKarakterek = Character.valueOf(sKarakterlanc.charAt(0)), cHelyetesitoKarakter = '!';
        char[] Karaktercsere = sKarakterlanc.toCharArray();

        while (iKarakterPozicioja < sKarakterlanc.length()) {
            if (Karaktercsere[iKarakterPozicioja] == cKicserelendoKarakterek) {
                Karaktercsere[iKarakterPozicioja] = cHelyetesitoKarakter;
            }
            iKarakterPozicioja++;
        }
        
        System.out.printf("\nA/Az %c karakter kicserelese %c-re utan a karakterlanc: ", sKarakterlanc.charAt(0), cHelyetesitoKarakter);
        System.out.print(Karaktercsere);

        // Beepitett Java metodus segitsegevel
        String sModositottKarakterlanc = sKarakterlanc.replaceAll(String.valueOf(sKarakterlanc.charAt(0)), "!");
        System.out.println();
        System.out.println("Beepiett metodus segitsegevel modositott karakterlanc: " + sModositottKarakterlanc);
    }
}