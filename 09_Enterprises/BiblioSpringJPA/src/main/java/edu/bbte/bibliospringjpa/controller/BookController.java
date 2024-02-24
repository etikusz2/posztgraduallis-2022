package edu.bbte.bibliospringjpa.controller;

import edu.bbte.bibliospringjpa.model.Book;
import edu.bbte.bibliospringjpa.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

}
