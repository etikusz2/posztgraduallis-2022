package edu.bbte.bibliospringspringdata.repository;

import edu.bbte.bibliospringspringdata.model.Author;
import edu.bbte.bibliospringspringdata.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleStartingWith(String title);

    List<Book> findByAuthor(Author author);
}
