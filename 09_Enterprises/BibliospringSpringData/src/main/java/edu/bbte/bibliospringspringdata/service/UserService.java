package edu.bbte.bibliospringspringdata.service;

import edu.bbte.bibliospringspringdata.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User create(User user);

    User update(User user);

    boolean deleteById(Long id);

    List<User> getAll();

    User getById(Long id);

    boolean login(String username, String password);
}
