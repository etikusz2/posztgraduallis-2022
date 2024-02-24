package edu.bbte.vizsga.backend.repository.file;

import edu.bbte.vizsga.backend.repository.DaoFactory;
import edu.bbte.vizsga.backend.repository.EmployeeDao;

public class FileDaoFactory implements DaoFactory {
    @Override
    public EmployeeDao createEmployeeDAO() {
        return new EmployeeFileDao();
    }
}
