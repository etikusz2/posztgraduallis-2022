package edu.bbte.bibliospringjpa.repository.jpa;

import edu.bbte.bibliospringjpa.model.Book;
import edu.bbte.bibliospringjpa.repository.BookDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookJPARepository extends BaseJPARepository<Book, Long> implements BookDAO {

    public BookJPARepository() {
        super(Book.class);
    }
}
