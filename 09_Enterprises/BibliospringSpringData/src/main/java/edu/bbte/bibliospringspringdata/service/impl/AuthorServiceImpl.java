package edu.bbte.bibliospringspringdata.service.impl;

import edu.bbte.bibliospringspringdata.model.Author;
import edu.bbte.bibliospringspringdata.repository.AuthorRepository;
import edu.bbte.bibliospringspringdata.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author create(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.saveAndFlush(author);
    }

    @Override
    public boolean deleteById(Long aid) {
        if (authorRepository.existsById(aid)) {
            authorRepository.deleteById(aid);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long aid) {
        return authorRepository.findById(aid).orElse(null);
    }
}
