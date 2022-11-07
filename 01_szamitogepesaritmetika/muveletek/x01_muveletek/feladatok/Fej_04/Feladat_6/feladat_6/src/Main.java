import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //  Írj egy programot ami véletlenszerűen egyenletesen választ egy hossz értéket 5 és 10 között (5 és 10 is lehet),
        //  majd generál egy olyan véletlen karakterláncot, aminek hossza ez a szám.
        //  A karakterei pedig kizárólag kis betűk, nagy betűk, vagy számok. Pl: hossz 7, karakterlánc: aFst5Gw.

        Random r = new Random();
        int iVeletlenSzam = r.nextInt(5, 11);
        int iKarakterlancHossza = iVeletlenSzam;
        int iAlsohatar = 48;
        int iFelsohatar = 122;

        String sVeletlenKarakterlanc = r.ints(iAlsohatar, iFelsohatar + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(iKarakterlancHossza)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(sVeletlenKarakterlanc);
    }
}
