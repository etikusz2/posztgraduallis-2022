package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.model.Authors;

public interface AuthorsService {
    public Authors create(Authors author);
    public void delete(Long id);
    public void update(Authors author);

    Authors getAuthorByName(String fullname);
}