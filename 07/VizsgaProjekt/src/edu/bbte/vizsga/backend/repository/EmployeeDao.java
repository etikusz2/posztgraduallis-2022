package edu.bbte.vizsga.backend.repository;

import edu.bbte.vizsga.backend.model.User;

public interface EmployeeDao {
    User getUserByName(String name);
}

