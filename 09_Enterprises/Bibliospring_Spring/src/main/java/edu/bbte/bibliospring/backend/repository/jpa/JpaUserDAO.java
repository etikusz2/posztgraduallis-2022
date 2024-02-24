package edu.bbte.bibliospring.backend.repository.jpa;

import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.UserDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("jpa")
public class JpaUserDAO extends BaseRepository<User, Long> implements UserDAO{

    @Override
    public void delete(Long id) throws RepositoryException {

    }

    @Override
    public User getByUserName(String userName) throws RepositoryException {
        return null;
    }
}
