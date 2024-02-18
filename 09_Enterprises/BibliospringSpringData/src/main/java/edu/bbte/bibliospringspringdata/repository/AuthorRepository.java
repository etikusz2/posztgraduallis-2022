package edu.bbte.bibliospringspringdata.repository;

import edu.bbte.bibliospringspringdata.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.authorName LIKE ?1%")
    List<Author> findByAuthorNameStartingWith(String authorName);

}
