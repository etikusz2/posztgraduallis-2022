package edu.bbte.bibliospring.backend.repository.memory;

import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Profile("memory")
public class MemoryUserDAO implements UserDAO {
    private ConcurrentHashMap<Long, User> users;
    private AtomicLong IDgenerator;

    public MemoryUserDAO(){
        users = new ConcurrentHashMap<>();
        IDgenerator = new AtomicLong();
    }

    @Override
    public User create(User user) {
        user.setID(IDgenerator.incrementAndGet());
        user.getUid();
        users.put(user.getID(), user);
        return user;
    }

    @Override
    public void delete(Long id) throws RepositoryException {

    }

    @Override
    public User update(User entity) throws RepositoryException {
        return null;
    }

    @Override
    public User getByID(Long ID) {
        return users.get(ID);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getByUserName(String userName) throws RepositoryException {
        Optional<User> resultUser = users.values().stream().filter(u -> u.getUserName().equals(userName)).findAny();
        if (resultUser.isPresent()){
            return resultUser.get();
        } else {
            return null;
        }
        //return resultUser.get();
    }
}
