enum ForgovillaAllapot {
    Nyitva,
    Foglalt,
    Zarva
}

enum ForgovillaEsemeny {
    AthaladasiKiserlet,
    KilepesATuloldalt,
    KilespesABejaratfele,
    ZsetonBedobas
}

public class Main {
    // Egy alap forgóvillának két állapota van (nyitva és zárva), illetve két alap eseménye (pénz bedobás és áthaladási kísérlet).
    // Az ilyen forgóvilla nem képes modellezni azt ahelyzetet, amikor valaki elkezd áthaladni a forgóvillán,
    // de meggondolja magát és visszafordul.Készítsen olyan forgóvilla modellt, ami kezelni tudja ezt az esetet is.
    // Határozza meg a kibővített állapotok és események halmazát, és implementálja az új állapot kiszámoló függvényt ezeknek megfelelően.
    public static void main(String[] args) {
        ForgovillaAllapot FobejaratKapuja = ForgovillaAllapot.Zarva;

//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.AthaladasiKiserlet);
//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja,ForgovillaEsemeny.AthaladasiKiserlet);
//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.ZsetonBedobas);
//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.KilespesABejaratfele);
//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja,ForgovillaEsemeny.ZsetonBedobas);
//        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.AthaladasiKiserlet);

        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.ZsetonBedobas);
        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.AthaladasiKiserlet);
        FobejaratKapuja = ForgovillaKovetkezoAllapota(FobejaratKapuja, ForgovillaEsemeny.KilepesATuloldalt);

    }

    private static ForgovillaAllapot ForgovillaKovetkezoAllapota(
            ForgovillaAllapot aktualisAllapot,
            ForgovillaEsemeny aktualisEsemeny
    ) {
        switch (aktualisAllapot) {
            case Nyitva:
                switch (aktualisEsemeny) {
                    case AthaladasiKiserlet:
                        return ForgovillaAllapot.Foglalt;
                    case ZsetonBedobas:
                        return ForgovillaAllapot.Nyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            case Foglalt:
                switch (aktualisEsemeny) {
                    case KilepesATuloldalt:
                        return ForgovillaAllapot.Zarva;
                    case KilespesABejaratfele:
                        return ForgovillaAllapot.Nyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            case Zarva:
                switch (aktualisEsemeny) {
                    case AthaladasiKiserlet:
                        return ForgovillaAllapot.Zarva;
                    case ZsetonBedobas:
                        return ForgovillaAllapot.Nyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}