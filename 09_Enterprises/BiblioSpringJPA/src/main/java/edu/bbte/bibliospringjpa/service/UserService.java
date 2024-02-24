package edu.bbte.bibliospringjpa.service;

import edu.bbte.bibliospringjpa.model.User;

import java.util.List;

public interface UserService {

    public User update(User user);

    public boolean delete(User user);

    public User getById(Long id);

    public List<User> getAll();


}
