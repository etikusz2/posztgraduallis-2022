package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryUserDAO implements UserDAO {
    private final ConcurrentHashMap<Long, User> users;
    private final AtomicLong idGenerator;

    public MemoryUserDAO() {
        users = new ConcurrentHashMap<>();
        idGenerator = new AtomicLong();
    }

    @Override
    public User create(User user) {
        user.setId(idGenerator.incrementAndGet());
        user.getUid();
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getByID(Long id) {
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getByUserName(String userName) throws RepositoryException {
        Optional<User> resultUser = users.values().stream().filter(u -> u.getUserName().equals(userName)).findAny();
        return resultUser.orElse(null);
        //return resultUser.get();
    }
}
