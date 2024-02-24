package edu.bbte.bibliospringjpa;

import edu.bbte.bibliospringjpa.model.User;
import edu.bbte.bibliospringjpa.repository.UserDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliospringJpaApplication {
    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        SpringApplication.run(BibliospringJpaApplication.class, args);
    }

    @PostConstruct
    public void run() {
        User user = new User();
        user.setUsername("testjpa");
        user.setPassword("testjpa");
        //userDAO.create(user);
    }

}
