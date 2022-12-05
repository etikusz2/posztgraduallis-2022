import java.util.Random;

enum ForgovillaAllapot {
    Nyitva,
    Zarva
}

enum ForgovillaEsemeny {
    Penzbedobas,
    Nyomas,
    Atforgas
}

public class Main {

    // Írjon egy programot, ami megvalósítja egy forgóvilla állapotgépét
    // (nyitott és zárt állapot, pénzbetételre egy átforgást engedélyez, amúgy nyomásnak ellenáll).
    //Egy 1000 hosszú optimális eseménysorozat lenne, hogy 500x ismétlődne a pénzbedobás, átmenés sorozata.
    // Próbálja ki, hogy hány sikeres átjutás történik,
    // ha az 1000 próbálkozás mindegyike véletlenszerűen pénzbedobás vagy átmenési kisérlet.
    private static final Random rteszt = new Random();

    public static void main(String[] args) {
        String forgovillateszt = ForgovillaAllapot.Zarva.toString();
        int AtjutasokSzama = 0;
        for (int i = 0; i < 1000; i++) {
            forgovillateszt = ForgovillaKovetkezoAllapota(ForgovillaAllapot.valueOf(forgovillateszt), RandomEsemeny()).toString();
            if (forgovillateszt.equals("Nyitva"))
                AtjutasokSzama++;
        }
        System.out.println("A forgovillan valo atjutasok szama 1000 veletlenszeru esemny utan = " + AtjutasokSzama);
    }

    private static ForgovillaAllapot ForgovillaKovetkezoAllapota(
            ForgovillaAllapot aktualisAllapot,
            ForgovillaEsemeny aktualisEsemeny
    ) {
        switch (aktualisAllapot) {
            case Nyitva:
                return switch (aktualisEsemeny) {
                    case Nyomas, Atforgas, Penzbedobas -> ForgovillaAllapot.Zarva;
                };
            case Zarva:
                return switch (aktualisEsemeny) {
                    case Nyomas, Atforgas -> ForgovillaAllapot.Zarva;
                    case Penzbedobas -> ForgovillaAllapot.Nyitva;
                };
            default:
                throw new IllegalArgumentException();
        }
    }

    private static ForgovillaEsemeny RandomEsemeny() {
        ForgovillaEsemeny[] LehetsegesEsemenyek = ForgovillaEsemeny.values();
        return LehetsegesEsemenyek[rteszt.nextInt(LehetsegesEsemenyek.length)];
    }
}