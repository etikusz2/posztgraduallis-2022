import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    // Írjunk  egy  programot  ami  az  aktuális  könyvtárban  létrehoz  egy  _DataFiles  könyvtárat,
    // majd  a consoleról *-ig beolvasott nevű fájlokat hoz létre ebben a könyvtárban.
    public static void main(String[] args) throws IOException {
        Path newDirectoryPath = Paths.get("_DataFiles");
        File newDirectory = newDirectoryPath.toFile();
        newDirectory.mkdirs();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Adjon meg egy file nevet(*-al kilep): ");
            Path newFilePath = Paths.get("_DataFiles/");
            File newFile = newFilePath.toFile();
            newFile.createNewFile();

        } while (filename.compareTo("*") == 0);
    }
}