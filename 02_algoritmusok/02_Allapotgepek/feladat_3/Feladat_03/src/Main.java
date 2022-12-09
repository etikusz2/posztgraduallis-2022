enum FotocellaAllapot {
    Zarva,
    FeligZarva_FeligNyitva,
    Nyitva
}

enum FotocellaEsemeny {
    Megkozelites,
    BelepesAzAjton,
    Visszafordulas,
    Nekifutas
}

public class Main {
    // Írjon egy állapotgépet ami egy fotocellás ajtó működését modellezi.
    // Modellezze, hogy milyen állapotai lehetnek, illetve milyen ingerek érhetnek egy fotocellás ajtót.
    public static void main(String[] args) {
FotocellaAllapot fotocellateszt = FotocellaAllapot.Zarva;

fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.Nekifutas);
fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.Megkozelites);
fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.Nekifutas);
fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.Megkozelites);
fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.Visszafordulas);
fotocellateszt = AfotocellaKovetkezoAllapota(fotocellateszt, FotocellaEsemeny.BelepesAzAjton);
    }

    private static FotocellaAllapot AfotocellaKovetkezoAllapota(
            FotocellaAllapot aktualisallapot,
            FotocellaEsemeny aktualisesemeny
    ) {
        switch (aktualisallapot) {
            case FeligZarva_FeligNyitva:
                switch (aktualisesemeny) {
                    case BelepesAzAjton:
                        return FotocellaAllapot.FeligZarva_FeligNyitva;
                    case Visszafordulas:
                        return FotocellaAllapot.Zarva;
                    case Nekifutas:
                        return FotocellaAllapot.Nyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            case Nyitva:
                switch (aktualisesemeny) {
                    case Megkozelites:
                    case Nekifutas:
                        return FotocellaAllapot.Nyitva;
                    case Visszafordulas:
                    case BelepesAzAjton:
                        return FotocellaAllapot.FeligZarva_FeligNyitva;
                    default:
                        throw new IllegalArgumentException();
                }
            case Zarva:
                switch (aktualisesemeny) {
                    case Megkozelites:
                        return FotocellaAllapot.FeligZarva_FeligNyitva;
                    case Nekifutas:
                        return FotocellaAllapot.Zarva;
                    default:
                        throw new IllegalArgumentException();
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}