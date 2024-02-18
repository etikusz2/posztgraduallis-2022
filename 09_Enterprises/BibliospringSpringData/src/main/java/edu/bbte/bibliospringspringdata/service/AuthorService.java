package edu.bbte.bibliospringspringdata.service;

import edu.bbte.bibliospringspringdata.model.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);

    Author update(Author author);

    boolean deleteById(Long aid);

    List<Author> getAll();

    Author getById(Long aid);
}
