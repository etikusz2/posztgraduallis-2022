package edu.bbte.vizsga.backend.repository.file;

import edu.bbte.vizsga.backend.model.User;
import edu.bbte.vizsga.backend.repository.EmployeeDao;
import edu.bbte.vizsga.backend.repository.RepositoryException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EmployeeFileDao implements EmployeeDao {
    private Map<String, User> employeeMap;

    public EmployeeFileDao() {
        employeeMap = new HashMap<>();
        loadEmployeesFromFile("data.txt");
    }

    private void loadEmployeesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    employeeMap.put(name, new User(name, phoneNumber));
                }
            }
        } catch (IOException e) {
            throw new RepositoryException("Error loading employees from file");
        }
    }

    @Override
    public User getUserByName(String name) {
        return employeeMap.get(name);
    }
}
