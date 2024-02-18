package edu.bbte.bibliospringspringdata.api;

import edu.bbte.bibliospringspringdata.assemblers.BookAssembler;
import edu.bbte.bibliospringspringdata.assemblers.UserAssembler;
import edu.bbte.bibliospringspringdata.dto.incoming.BookInDTO;
import edu.bbte.bibliospringspringdata.dto.incoming.UserInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.BookOutDTO;
import edu.bbte.bibliospringspringdata.model.Author;
import edu.bbte.bibliospringspringdata.model.Book;
import edu.bbte.bibliospringspringdata.model.User;
import edu.bbte.bibliospringspringdata.service.BookService;
import edu.bbte.bibliospringspringdata.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebController {

    private final BookService bookService;
    private final UserService userService;
    private final BookAssembler bookAssembler;
    private final UserAssembler userAssembler;

    @Autowired
    public WebController(BookService bookService,
                         UserService userService,
                         BookAssembler bookAssembler,
                         UserAssembler userAssembler) {
        this.bookService = bookService;
        this.userService = userService;
        this.bookAssembler = bookAssembler;
        this.userAssembler = userAssembler;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserInDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserInDTO userDTO, HttpSession session, Model model) {
        if (userService.login(userDTO.getUsername(), userDTO.getPassword())) {
            session.setAttribute("loggedInUser", userDTO);
            return "redirect:/books";
        } else {
            model.addAttribute("loginError", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", new UserInDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("newUser") UserInDTO newUserDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            User newUser = userAssembler.userInDtoToModel(newUserDTO);
            userService.create(newUser);
            return "redirect:/login";
        } catch (ServiceException e) {
            model.addAttribute("registrationError", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        List<BookOutDTO> booksDto = bookService.getAllBooksSortedByAuthor().stream()
                .map(bookAssembler::modelToBookOutDto)
                .collect(Collectors.toList());
        model.addAttribute("books", booksDto);
        return "books";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new BookInDTO());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute("book") BookInDTO bookDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "addbook";
        }

        Book book = bookAssembler.bookInDtoToModel(bookDTO);
        bookService.create(book);
        return "redirect:/books";
    }

    @GetMapping("/book/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getById(id);
        if (book == null) {
            return "redirect:/error";
        }
        BookOutDTO bookDto = bookAssembler.modelToBookOutDto(book);
        model.addAttribute("book", bookDto);
        return "editbook";
    }

    @PostMapping("/book/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") BookInDTO bookDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "editbook";
        }

        Book existingBook = bookService.getById(id);
        if (existingBook == null) {
            return "redirect:/error";
        }

        // Módosítsa az existingBook objektumot a bookDTO alapján
        // Feltételezve, hogy a bookAssembler.bookInDtoToModel visszaad egy frissített Book objektumot
        // amelyet aztán használni tudunk az existingBook frissítésére.
        Book updatedBook = bookAssembler.bookInDtoToModel(bookDTO);

        // Itt feltételezzük, hogy az existingBook objektum frissítése a szükséges mezőkkel történik.
        // Ezt a lépést az Ön igényei szerint kell módosítani.
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        // További mezők frissítése szükség szerint...

        bookService.update(existingBook);

        return "redirect:/books";
    }


    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(value = "title", required = false) String title,
                              @RequestParam(value = "authorName", required = false) String authorName,
                              Model model) {
        List<Book> searchResults = new ArrayList<>();

        if (title != null && !title.isEmpty()) {
            // Cím alapján történő keresés
            searchResults.addAll(bookService.findByTitleStartingWith(title));
        }

        if (authorName != null && !authorName.isEmpty()) {
            // Szerző neve alapján történő keresés, majd a szerzőhöz tartozó könyvek keresése
            List<Author> authors = bookService.findByAuthorNameStartingWith(authorName);
            for (Author author : authors) {
                searchResults.addAll(bookService.findBooksByAuthor(author));
            }
        }

        model.addAttribute("books", searchResults);
        return "searchResults";
    }
}

