package edu.bbte.bibliospring;

import edu.bbte.bibliospring.backend.service.BookService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliospringSpringApplication {

    @Autowired
    private BookService bookService;
    @Autowired
    private Logger Log;
    public static void main(String[] args) {
        SpringApplication.run(BibliospringSpringApplication.class, args);
    }

    @PostConstruct
    public void postConstruct(){
        Log.info("Hello!");
        Log.info(bookService.getByID(12L).getTitle());;
    }
}
