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
        Scanner sc = new Scanner(System.in);
        System.out.println("Mi legyen az ujfajl neve?");
        File newFile = new File(sc.nextLine());
        Path newFilePath = Paths.get("_DataFiles/" + newFile);
        newFile = newFilePath.toFile();
        if (!newFile.getName().equals("*"))
            newFile.createNewFile();
        while (!newFile.getName().equals("*")){
            System.out.println("Mi legyen az ujfajl neve?");
            newFile = new File(sc.nextLine());
            newFilePath = Paths.get("_DataFiles/" + newFile);
            newFile = newFilePath.toFile();
            if (!newFile.getName().equals("*"))
            newFile.createNewFile();
        }
    }
}