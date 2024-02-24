package edu.bbte.bibliospringjpa.repository.jpa;

import edu.bbte.bibliospringjpa.model.User;
import edu.bbte.bibliospringjpa.repository.RepositoryException;
import edu.bbte.bibliospringjpa.repository.UserDAO;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserJPARepository extends BaseJPARepository<User, Long> implements UserDAO {
    @Autowired
    private Logger LOG;

    public UserJPARepository() {
        super(User.class);
    }

    @Override
    public User getByUsername(String username) {
        try {
            TypedQuery<User> typedQuery = entityManager.createQuery("FROM User u WHERE u.username = :username", User.class);
            typedQuery.setParameter("username", username);
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            LOG.error("User selection failed!", e);
            throw new RepositoryException("User selection failed!", e);
        }
    }
}
