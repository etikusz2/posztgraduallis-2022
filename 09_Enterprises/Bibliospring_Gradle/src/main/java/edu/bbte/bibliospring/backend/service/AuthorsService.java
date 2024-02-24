package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Authors;

public interface AuthorsService {
    Authors create(Authors author);

    void delete(Long id);

    void update(Authors author);

    Authors getAuthorByName(String fullname);
}