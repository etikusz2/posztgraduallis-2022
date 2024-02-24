package edu.bbte.bibliospring.backend.service.impl;

import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.UserDAO;
import edu.bbte.bibliospring.backend.service.LoginService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private Logger LOG;

    @Override
    public boolean login(User user) {
        try {
            User dbUser = userDAO.getByUserName(user.getUserName());
            if (dbUser == null) {
                return false;
            } else {
                String hashedPassword = generateHashedPassword(user.getPassword(), dbUser.getUid());
                return dbUser.getPassword().equals(hashedPassword);
            }
        } catch (RepositoryException e) {
            LOG.error("Login failed.");
            throw new ServiceException("Login failed.", e);
        }
    }

    @Override
    public User register(User user) {
        try {
            user.setPassword(generateHashedPassword(user.getPassword(), user.getUid()));
            return userDAO.create(user);
        } catch (RepositoryException e) {
            LOG.error("User registration failed.");
            throw new ServiceException("User registration failed.", e);
        }
    }

    private String generateHashedPassword(String plainPassword, String salt){
        try {
            byte[] input = (plainPassword + salt).getBytes();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.reset();
            md.update(input);
            byte[] output = md.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < output.length; i++) {
                stringBuilder.append(String.format("%02x", output[i]));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            LOG.error("Password hashing failed", e);
            throw new ServiceException("Password hashing failed", e);
        }
    }
}
