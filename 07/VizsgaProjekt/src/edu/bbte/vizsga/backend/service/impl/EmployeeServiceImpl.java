package edu.bbte.vizsga.backend.service.impl;

import edu.bbte.vizsga.backend.model.User;
import edu.bbte.vizsga.backend.repository.EmployeeDao;
import edu.bbte.vizsga.backend.service.EmployeeService;
import edu.bbte.vizsga.backend.service.ServiceException;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public boolean authenticateEmployee(String userName) {
        return employeeDao.getUserByName(userName) != null;
    }

    @Override
    public String getEmployeeContact(String requestedName) throws ServiceException {
        User user = employeeDao.getUserByName(requestedName);
        if (user != null) {
            return user.getPhoneNumber();
        } else {
            throw new ServiceException("Employee not found: " + requestedName);
        }
    }
}
