package edu.bbte.bibliospringspringdata.service.impl;

import edu.bbte.bibliospringspringdata.model.User;
import edu.bbte.bibliospringspringdata.repository.UserRepository;
import edu.bbte.bibliospringspringdata.service.UserService;
import edu.bbte.bibliospringspringdata.util.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncrypter passwordEncrypter;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncrypter.generateHashedPassword(user.getPassword(), user.getUuid()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        user.setPassword(passwordEncrypter.generateHashedPassword(user.getPassword(), user.getUuid()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean deleteById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(String.valueOf(username));
        if (user != null) {
            String hashedPassword = passwordEncrypter.generateHashedPassword(String.valueOf(password), user.getUuid());
            return user.getPassword().equals(hashedPassword);
        }
        return false;
    }


}
