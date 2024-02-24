package edu.bbte.bibliospring.backend.web;

import edu.bbte.bibliospring.backend.model.Book;
import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.service.BookService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String showBooks(Model model, HttpSession session) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        // Ellenőrizzük, hogy be van-e jelentkezve a felhasználó
        if (session.getAttribute("loggedInUser") != null) {
            String username = ((User) session.getAttribute("loggedInUser")).getUserName();
            model.addAttribute("username", username);
        }

        return "books";
    }

    @GetMapping("/addBook")
    public String showAddBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String addBook(Book newBook, Model model) {
        try {
            bookService.create(newBook);
            return "redirect:/books";
        } catch (ServiceException e) {
            model.addAttribute("error", "Book creation failed. Please try again.");
            return "addBook";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getByID(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("book") Book editedBook, RedirectAttributes redirectAttributes) {
        try {
            bookService.update(editedBook);
            redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully.");
        } catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Book update failed. Please try again.");
        }
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bookService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully.");
        } catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Book deletion failed. Please try again.");
        }
        return "redirect:/books";
    }


    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("searchTerm", "");
        return "search";
    }

    @PostMapping("/search")
    public String searchBooks(@RequestParam String searchTerm, Model model) {
        List<Book> searchResults = bookService.searchByTitleOrAuthor(searchTerm);
        model.addAttribute("books", searchResults);
        return "books";
    }

    @GetMapping("/refresh")
    public String refreshBooks() {
        return "redirect:/books";
    }

    @GetMapping("/logout")
    public String showLogoutForm() {
        return "logout";
    }
}
