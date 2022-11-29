import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    // Írjon egy programot ami két parancssori argumentumot vár.
    // Az első egy könyvtár elérési útja, a második  egy  fájl  neve.
    // Egy  rekurzív  függvény  segítségével  döntse  el,
    // hogy  van-e  olyan  fájl  a könyvtárban (vagy bármely abban lévő könyvtárban tetszőleges mélységben)
    // bárhol olyan nevű fájl. Ha vannak ilyenek, ezeknek a teljes elérési útját írja ki a consolere.
    public static void main(String[] args) {
        // konyvtar eleresi utja
        Path KonyvtarEleresiUtja = Paths.get(args[0]);
        File KonyvtarInfo = KonyvtarEleresiUtja.toFile();

        // fajl neve
        String FajlNeve = args[1];
        FajlKereso(KonyvtarInfo, FajlNeve);

    }

    private static void FajlKereso(File KonyvtarInfo, String FajlNeve) {
        if (!KonyvtarInfo.exists()) {
            throw new IllegalArgumentException("A " + KonyvtarInfo + " nem letezik!");
        } else if (KonyvtarInfo.isFile() && KonyvtarInfo.getName().equals(FajlNeve)) {
            System.out.println(FajlNeve + " eleresi utja: " + KonyvtarInfo.getAbsolutePath());
        } else {
            File[] KonyvtarTartalma = KonyvtarInfo.listFiles();
            if (KonyvtarTartalma != null) {
                for (File FajlneveKereses : KonyvtarTartalma) {
                    if (FajlneveKereses.getName().equals(FajlNeve)) {
                        System.out.println(FajlNeve + " eleresi utja: " + FajlneveKereses.getAbsolutePath());
                    } else FajlKereso(FajlneveKereses, FajlNeve);
                }
            }
        }
    }
}