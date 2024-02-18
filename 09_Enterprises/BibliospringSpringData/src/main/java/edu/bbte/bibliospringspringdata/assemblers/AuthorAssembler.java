package edu.bbte.bibliospringspringdata.assemblers;

import edu.bbte.bibliospringspringdata.dto.incoming.AuthorInDTO;
import edu.bbte.bibliospringspringdata.dto.outgoing.AuthorOutDTO;
import edu.bbte.bibliospringspringdata.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorAssembler {

    public Author authorInDtoToModel(AuthorInDTO authorInDTO) {
        Author author = new Author();
        author.setAuthorName(authorInDTO.getAuthorName());
        return author;
    }

    public AuthorOutDTO modelToAuthorOutDto(Author author) {
        AuthorOutDTO authorOutDTO = new AuthorOutDTO();
        authorOutDTO.setUid(author.getUuid());
        authorOutDTO.setId(author.getId());
        authorOutDTO.setAuthorName(author.getAuthorName());
        return authorOutDTO;
    }
}
