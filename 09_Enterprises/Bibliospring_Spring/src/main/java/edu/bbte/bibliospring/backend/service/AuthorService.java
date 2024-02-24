package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Author;

public interface AuthorService {
    public Author create(Author author);
    public void delete(Long id);
    public void update(Author author);

    Author getAuthorByName(String fullname);
}