package edu.bbte.bibliospringspringdata.api;

import edu.bbte.bibliospringspringdata.assemblers.BookAssembler;
import edu.bbte.bibliospringspringdata.assemblers.UserAssembler;
import edu.bbte.bibliospringspringdata.dto.incoming.BookInDTO;
import edu.bbte.bibliospringspringdata.dto.incoming.UserInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.BookOutDTO;
import edu.bbte.bibliospringspringdata.model.Book;
import edu.bbte.bibliospringspringdata.service.BookService;
import edu.bbte.bibliospringspringdata.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WebControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private UserService userService;

    @Mock
    private BookAssembler bookAssembler;

    @Mock
    private UserAssembler userAssembler;

    @Mock
    private Model model;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private HttpSession session;

    @InjectMocks
    private WebController webController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenBookswhenListingBooksthenShouldAddBooksToModel() {
        List<Book> books = List.of(new Book());
        when(bookService.getAllBooksSortedByAuthor()).thenReturn(books);

        BookOutDTO bookOutDTO = new BookOutDTO();
        when(bookAssembler.modelToBookOutDto(any(Book.class))).thenReturn(bookOutDTO);

        Model model = mock(Model.class);

        WebController controller = new WebController(bookService, userService, bookAssembler, userAssembler);
        String viewName = controller.showBooks(model);

        verify(model).addAttribute(eq("books"), anyList());
        verify(bookService).getAllBooksSortedByAuthor();

        assertEquals("books", viewName, "This is the books view"); // Feltételezve, hogy "books" a nézet neve
    }


    @Test
    void showEditBookFormBookExistsShouldAddBookToModel() {
        Long bookId = 1L;
        Book book = new Book();
        book.setId(bookId);
        when(bookService.getById(bookId)).thenReturn(book);

        BookOutDTO bookOutDTO = new BookOutDTO();
        when(bookAssembler.modelToBookOutDto(book)).thenReturn(bookOutDTO);

        String viewName = webController.showEditBookForm(bookId, model);

        assertThat(viewName).isEqualTo("editbook");
        verify(model).addAttribute("book", bookOutDTO);
        verify(bookService).getById(bookId);
    }

    @Test
    void showRegisterFormShouldAddNewUserToModel() {
        webController.showRegisterForm(model);

        verify(model).addAttribute(eq("newUser"), any(UserInDTO.class));

        verify(model).addAttribute(eq("newUser"), isA(UserInDTO.class));
    }


    @Test
    void registerUserWithErrorsShouldReturnRegisterView() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = webController.registerUser(new UserInDTO(), bindingResult, model);

        assertThat(viewName).isEqualTo("register");
        verify(bindingResult).hasErrors();
    }

    @Test
    void showAddBookFormShouldAddBookToModel() {
        String viewName = webController.showAddBookForm(model);

        assertThat(viewName).isEqualTo("addbook");
        verify(model).addAttribute(eq("book"), any(BookInDTO.class));
    }

    @Test
    void addBookWithErrorsShouldReturnAddBookView() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = webController.addBook(new BookInDTO(), bindingResult);

        assertThat(viewName).isEqualTo("addbook");
        verify(bindingResult).hasErrors();
    }

    @Test
    void showEditBookFormBookDoesNotExistShouldRedirectToError() {
        Long bookId = 1L;
        when(bookService.getById(bookId)).thenReturn(null);

        String viewName = webController.showEditBookForm(bookId, model);

        assertThat(viewName).isEqualTo("redirect:/error");
        verify(bookService).getById(bookId);
    }

    @Test
    void editBookWithErrorsShouldReturnEditBookView() {
        when(bindingResult.hasErrors()).thenReturn(true);

        String viewName = webController.editBook(1L, new BookInDTO(), bindingResult);

        assertThat(viewName).isEqualTo("editbook");
        verify(bindingResult).hasErrors();
    }

    @Test
    void deleteBookShouldRedirectToBooks() {
        Long bookId = 1L;

        String viewName = webController.deleteBook(bookId);

        assertThat(viewName).isEqualTo("redirect:/books");
        verify(bookService).deleteById(bookId);
    }

    @Test
    void logoutShouldInvalidateSessionAndRedirect() {
        String viewName = webController.logout(session);

        assertThat(viewName).isEqualTo("redirect:/login");
        verify(session).invalidate();
    }
}
