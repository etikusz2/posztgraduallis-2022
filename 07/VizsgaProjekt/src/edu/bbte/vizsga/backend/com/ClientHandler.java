package edu.bbte.vizsga.backend.com;

import edu.bbte.vizsga.backend.service.EmployeeService;
import edu.bbte.vizsga.backend.service.ServiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket clientSocket;
    private EmployeeService employeeService;

    public ClientHandler(Socket clientSocket, EmployeeService employeeService) {
        this.clientSocket = clientSocket;
        this.employeeService = employeeService;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Kliens kérés: " + request);

                String[] requestParts = request.split("\\|");
                if (requestParts.length == 2 && requestParts[0].equals("user_name")) {
                    String userName = requestParts[1];

                    try {
                        String phoneNumber = employeeService.getEmployeeContact(userName);
                        System.out.println("Felhasználó telefonszáma: " + phoneNumber);
                        out.println("Elérhetőség: " + phoneNumber);
                    } catch (ServiceException e) {
                        out.println("Hiba: " + e.getMessage());
                        System.out.println("Hiba történt a kiszolgálás során: " + e.getMessage());
                    }
                } else {
                    out.println("Hiba: Érvénytelen kérés formátum");
                    System.out.println("Hiba: Érvénytelen kérés formátum");
                }

                out.flush();
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
