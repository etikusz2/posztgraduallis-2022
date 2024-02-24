package edu.bbte.vizsga.backend.com;

import edu.bbte.vizsga.backend.repository.EmployeeDao;
import edu.bbte.vizsga.backend.repository.file.EmployeeFileDao;
import edu.bbte.vizsga.backend.service.EmployeeService;
import edu.bbte.vizsga.backend.service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EmployeeServer {
    private static volatile boolean running = true;
    private static ServerSocket serverSocket;
    private static final int PORT = 3000;
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        initializeServer();

        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, employeeService).start();
            } catch (SocketException e) {
                if (!running) {
                    System.out.println("Server is shutting down.");
                    break;
                } else {
                    System.out.println("Connection reset. Restarting server...");
                    initializeServer();
                }
            } catch (IOException e) {
                throw new RuntimeException("Unexpected IOException", e);
            }
        }

        System.out.println("Server has been shut down.");
    }

    private static void initializeServer() {
        EmployeeDao employeeDao = new EmployeeFileDao();
        employeeService = new EmployeeServiceImpl(employeeDao);

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port " + PORT);
        } catch (IOException e) {
            throw new RuntimeException("Unexpected IOException", e);
        }
    }

    public static synchronized void stopServer() {
        running = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
