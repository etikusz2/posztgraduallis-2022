package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.model.Author;
import edu.bbte.bibliospring.backend.model.Book;
import edu.bbte.bibliospring.backend.repository.AuthorDAO;
import edu.bbte.bibliospring.backend.repository.BookDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("jdbc")
public class JdbcBookDAO implements BookDAO {

    @Autowired
    private Logger LOG;

    @Autowired
    private AuthorDAO authorDAO;

    @Autowired
    private ConnectionManager cm;

    @Override
    public Book create(Book book) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            Author author = book.getAuthor();
            if (author != null && author.getID() == null) {
                author = authorDAO.create(author);
                book.setAuthor(author);
            }

            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO books(`uid`, `title`, `aid`, `position`, `isbn`) VALUES(?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getUid());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setLong(3, book.getAuthor().getID());
            preparedStatement.setString(4, book.getPosition());
            preparedStatement.setString(5, book.getIsbn());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            book.setID(rs.getLong(1));

            con.commit();
        } catch (SQLException e) {
            handleSQLException(con, e, "Book creation failed");
        } finally {
            closeConnection(con);
        }
        return book;
    }

    @Override
    public void delete(Long id) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            PreparedStatement preparedStatement = con.prepareStatement(
                    "DELETE FROM books WHERE id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            handleSQLException(con, e, "Book deletion failed");
        } finally {
            closeConnection(con);
        }
    }

    @Override
    public Book getByID(Long id) {
        Book book = null;
        Connection con = null;
        PreparedStatement bookStatement = null;
        ResultSet bookResult = null;

        try {
            con = cm.getConnection();
            bookStatement = con.prepareStatement("SELECT * FROM books WHERE id = ?");
            bookStatement.setLong(1, id);
            bookResult = bookStatement.executeQuery();

            if (bookResult.next()) {
                book = new Book();
                book.setUid(bookResult.getString("uid"));
                book.setID(bookResult.getLong("id"));
                book.setTitle(bookResult.getString("title"));
                book.setPosition(bookResult.getString("position"));
                book.setIsbn(bookResult.getString("isbn"));

                Long authorId = bookResult.getLong("aid");
                if (!bookResult.wasNull()) {
                    Author author = authorDAO.getByID(authorId);
                    book.setAuthor(author);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error reading book", e);
            throw new RepositoryException("Error reading book", e);
        } finally {
            try {
                if (bookResult != null) {
                    bookResult.close();
                }
                if (bookStatement != null) {
                    bookStatement.close();
                }
            } catch (SQLException e) {
                LOG.error("Error closing resources", e);
            } finally {
                if (con != null) {
                    cm.returnConnection(con);
                }
            }
        }
        return book;
    }

    @Override
    public Long getIdByTitle(String title) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT id FROM books WHERE title = ?;"
            );
            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("id");
            } else {
                throw new RepositoryException("Book not found with title: " + title);
            }
        } catch (SQLException e) {
            LOG.error("Error getting book ID by title", e);
            throw new RepositoryException("Error getting book ID by title", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
    }

    @Override
    public Book update(Book book) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            Author author = book.getAuthor();
            if (author != null && author.getID() == null) {
                author = authorDAO.create(author);
                book.setAuthor(author);
            }

            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE books SET title = ?, aid = ?, position = ?, isbn = ? WHERE id = ?;");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setLong(2, book.getAuthor().getID());
            preparedStatement.setString(3, book.getPosition());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setLong(5, book.getID());
            preparedStatement.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            handleSQLException(con, e, "Book update failed");
        } finally {
            closeConnection(con);
        }
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        Connection con = null;
        try {
            con = cm.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Book book = new Book();
                book.setUid(rs.getString("uid"));
                book.setTitle(rs.getString("title"));
                book.setPosition(rs.getString("position"));
                book.setIsbn(rs.getString("isbn"));

                Long authorId = rs.getLong("aid");
                Author author = getAuthorById(con, authorId);
                book.setAuthor(author);

                books.add(book);
            }
        } catch (SQLException e) {
            LOG.error("Error reading books", e);
            throw new RepositoryException("Error reading books", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return books;
    }

    @Override
    public List<Book> searchByTitleOrAuthor(String searchTerm) {
        List<Book> searchResults = new ArrayList<>();
        Connection con = null;
        try {
            con = cm.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM books WHERE title LIKE ? OR aid IN (SELECT id FROM authors WHERE author LIKE ?);");
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setUid(rs.getString("uid"));
                book.setID(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setPosition(rs.getString("position"));
                book.setIsbn(rs.getString("isbn"));

                Long authorId = rs.getLong("aid");
                Author author = getAuthorById(con, authorId);
                book.setAuthor(author);

                searchResults.add(book);
            }
        } catch (SQLException e) {
            LOG.error("Error searching books", e);
            throw new RepositoryException("Error searching books", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return searchResults;
    }

    private Author getAuthorById(Connection con, Long authorId) throws SQLException {
        Author author = null;
        PreparedStatement authorStatement = con.prepareStatement("SELECT * FROM authors WHERE aid = ?");
        authorStatement.setLong(1, authorId);
        ResultSet authorResult = authorStatement.executeQuery();

        if (authorResult.next()) {
            author = new Author();
            author.setID(authorResult.getLong("aid"));
            author.setAuthor(authorResult.getString("author"));
        }
        return author;
    }

    private void handleSQLException(Connection con, SQLException e, String errorMessage) throws RepositoryException {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                LOG.error("Rollback failed", rollbackException);
            }
        }
        LOG.error(errorMessage, e);
        throw new RepositoryException(errorMessage, e);
    }

    private void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.setAutoCommit(true);
                cm.returnConnection(con);
            } catch (SQLException rollbackException) {
                LOG.error("Error resetting auto-commit mode", rollbackException);
            }
        }
    }
}