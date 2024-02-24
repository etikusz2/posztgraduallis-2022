package edu.bbte.vizsga.backend.service;

import edu.bbte.vizsga.backend.service.EmployeeService;

public interface ServiceFactory {
    EmployeeService createEmployeeService();
}
