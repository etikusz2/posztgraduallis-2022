package edu.bbte.bibliospringjpa.service.impl;

import edu.bbte.bibliospringjpa.model.User;
import edu.bbte.bibliospringjpa.repository.UserDAO;
import edu.bbte.bibliospringjpa.service.LoginService;
import edu.bbte.bibliospringjpa.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncrypter passwordEncrypter;

    @Override
    public boolean login(User user) {
        User dbUser = userDAO.getByUsername(user.getUsername());
        if (dbUser != null) {
            return dbUser.getPassword().equals(passwordEncrypter.generateHashedPassword(user.getPassword(), dbUser.getUuid()));
        } else{
            return false;
        }
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncrypter.generateHashedPassword(user.getPassword(), user.getUuid()));
        return userDAO.create(user);
    }
}
