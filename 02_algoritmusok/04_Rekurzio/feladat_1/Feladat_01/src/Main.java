public class Main {
    // Írjon rekurzív algotmut, ami egy tört számot megszoroz egy egész számmal,
    // kizárólag összeadás művelet használatával.
    public static void main(String[] args) {
        double Szorzat = SzorzasRek(0.25, -7);
        System.out.println(Szorzat);
    }

    private static double SzorzasRek(double Tort, int Egesz) {
        if (Egesz == 0) {
            return 0;
        }

        if (Egesz > 0)
            return SzorzasRek(Tort, Egesz - 1) + Tort;
        else
            return SzorzasRek(Tort, Egesz + 1) - Tort;

    }

    private static double Szorzat(double Tort, int Egesz) {
        if (Egesz < 0) {
            Tort = -Tort;
            Egesz = -Egesz;

        }
        return SzorzatNemNegativEgesszel(Tort, Egesz);
    }

    private static double SzorzatNemNegativEgesszel(double Tort, int Egesz) {
        if (Egesz == 0)
            return 0;
        double KisebbSzorzat = SzorzatNemNegativEgesszel(Tort, Egesz - 1);
        return KisebbSzorzat + Tort;
    }
}