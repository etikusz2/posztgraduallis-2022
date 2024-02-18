package edu.bbte.bibliospringspringdata.assemblers;

import edu.bbte.bibliospringspringdata.dto.incoming.BookInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.BookOutDTO;
import edu.bbte.bibliospringspringdata.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookAssembler {

    private final AuthorAssembler authorAssembler;

    public BookAssembler(AuthorAssembler authorAssembler) {
        this.authorAssembler = authorAssembler;
    }

    public Book bookInDtoToModel(BookInDTO bookInDTO) {
        Book book = new Book();
        book.setTitle(bookInDTO.getTitle());
        book.setPosition(bookInDTO.getPosition());
        book.setIsbn(bookInDTO.getIsbn());
        book.setAuthor(authorAssembler.authorInDtoToModel(bookInDTO.getAuthor()));
        return book;
    }

    public BookOutDTO modelToBookOutDto(Book book) {
        BookOutDTO bookOutDTO = new BookOutDTO();
        bookOutDTO.setUid(book.getUuid());
        bookOutDTO.setId(book.getId());
        bookOutDTO.setTitle(book.getTitle());
        bookOutDTO.setPosition(book.getPosition());
        bookOutDTO.setIsbn(book.getIsbn());
        bookOutDTO.setAuthor(authorAssembler.modelToAuthorOutDto(book.getAuthor()));
        return bookOutDTO;
    }
}
