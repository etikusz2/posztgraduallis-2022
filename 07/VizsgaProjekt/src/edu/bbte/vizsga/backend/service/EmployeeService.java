package edu.bbte.vizsga.backend.service;

public interface EmployeeService {
    boolean authenticateEmployee(String userName);
    String getEmployeeContact(String requestedName) throws ServiceException;
}
