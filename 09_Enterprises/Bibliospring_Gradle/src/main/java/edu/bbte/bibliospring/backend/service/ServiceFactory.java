package edu.bbte.bibliospring.backend.service;

import edu.bbte.bibliospring.backend.service.impl.AuthorsServiceImpl;
import edu.bbte.bibliospring.backend.service.impl.BooksServiceImpl;
import edu.bbte.bibliospring.backend.service.impl.LoginServiceImpl;

public class ServiceFactory {
    public static LoginService getLoginService() {
        return new LoginServiceImpl();
    }

    public static BooksService getBooksService() {
        return new BooksServiceImpl();
    }

    public static AuthorsService getAuthorsService() {
        return new AuthorsServiceImpl();
    }
}
