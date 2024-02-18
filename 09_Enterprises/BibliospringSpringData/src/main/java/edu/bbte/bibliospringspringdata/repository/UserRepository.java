package edu.bbte.bibliospringspringdata.repository;

import edu.bbte.bibliospringspringdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("FROM User u WHERE u.username=:username")
    User mindegyNevu(@Param("username") String username);

}
