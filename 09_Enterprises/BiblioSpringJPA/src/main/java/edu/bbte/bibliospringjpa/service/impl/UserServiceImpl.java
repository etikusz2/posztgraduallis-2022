package edu.bbte.bibliospringjpa.service.impl;

import edu.bbte.bibliospringjpa.model.User;
import edu.bbte.bibliospringjpa.repository.UserDAO;
import edu.bbte.bibliospringjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(User user) {
        return userDAO.deleteByID(user.getID());
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
