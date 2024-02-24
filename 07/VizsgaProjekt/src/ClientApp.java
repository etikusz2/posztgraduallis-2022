import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientApp {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 3000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in))) {

            // Felhasználónevek bekérése a konzolról
            System.out.print("Kérem, adja meg az első felhasználónevet: ");
            String username1 = userInputReader.readLine();

            System.out.print("Kérem, adja meg a második felhasználónevet: ");
            String username2 = userInputReader.readLine();

            // Küldés a szervernek
            out.println("user_name|" + username1);
            out.println("user_name|" + username2);

            // Válasz fogadása a szervertől
            String response1 = in.readLine();
            String response2 = in.readLine();

            // Kiírás a konzolra
            System.out.println("Válasz a szervertől (" + username1 + "): " + response1);
            System.out.println("Válasz a szervertől (" + username2 + "): " + response2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
