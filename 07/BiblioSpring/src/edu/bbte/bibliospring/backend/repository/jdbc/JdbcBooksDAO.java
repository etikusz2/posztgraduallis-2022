package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.model.Books;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.DAOFactory;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBooksDAO implements BooksDAO {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcBooksDAO.class);
    private DAOFactory daoFactory;
    private ConnectionManager cm = ConnectionManager.getInstance();
    public JdbcBooksDAO(AuthorsDAO authorsDAO){
        this.daoFactory = DAOFactory.getInstance();
    }
    @Override
    public Books create(Books book) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);
            AuthorsDAO authorsDAO = daoFactory.getAuthorsDAO();
            Authors author = book.getAuthor();
            if (author != null && author.getID() == null) {
                author = authorsDAO.create(author);
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

            con.commit(); // Tranzakció véglegesítése
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    LOG.error("Rollback failed", rollbackException);
                }
            }
            LOG.error("Book creation failed", e);
            throw new RepositoryException("Book creation failed", e);
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    cm.returnConnection(con);
                } catch (SQLException rollbackException) {
                    LOG.error("Error resetting auto-commit mode", rollbackException);
                }
            }
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
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    LOG.error("Rollback failed", rollbackException);
                }
            }
            LOG.error("Book deletion failed", e);
            throw new RepositoryException("Book deletion failed", e);
        } finally {
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

    @Override
    public Books getByID(Long id) {
        Books book = null;
        Connection con = null;
        try {
            con = cm.getConnection();

            PreparedStatement bookStatement = con.prepareStatement("SELECT * FROM books WHERE id = ?");
            bookStatement.setLong(1, id);
            ResultSet bookResult = bookStatement.executeQuery();

            if (bookResult.next()) {
                book = new Books();
                book.setUid(bookResult.getString("uid"));
                book.setID(bookResult.getLong("id"));
                book.setTitle(bookResult.getString("title"));
                book.setPosition(bookResult.getString("position"));
                book.setIsbn(bookResult.getString("isbn"));


                Long authorId = bookResult.getLong("author_id");
                if (authorId != null) {
                    AuthorsDAO authorDAO = daoFactory.getAuthorsDAO();
                    Authors author = authorDAO.getByID(authorId);
                    book.setAuthor(author);
                }
            }
        } catch (SQLException e) {
            LOG.error("Error reading book", e);
            throw new RepositoryException("Error reading book", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
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
    public Books update(Books book) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            // Ellenőrizzük, hogy a szerző létezik-e az adatbázisban
            AuthorsDAO authorDAO = daoFactory.getAuthorsDAO();
            Authors author = book.getAuthor();
            if (author != null && author.getID() == null) {
                author = authorDAO.create(author);
                book.setAuthor(author);
            }

            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE books SET title = ?, aid = ?, position = ?, isbn = ? WHERE id = ?;");
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setLong(2, book.getAuthor().getID());  // Helyesen beállítjuk az author id-t
            preparedStatement.setString(3, book.getPosition());
            preparedStatement.setString(4, book.getIsbn());
            preparedStatement.setLong(5, book.getID());
            preparedStatement.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    LOG.error("Rollback failed", rollbackException);
                }
            }
            LOG.error("Book update failed", e);
            throw new RepositoryException("Book update failed", e);
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    cm.returnConnection(con);
                } catch (SQLException rollbackException) {
                    LOG.error("Error resetting auto-commit mode", rollbackException);
                }
            }
        }
        return book;
    }


    @Override
    public List<Books> getAll() {
        List<Books> books = new ArrayList<>();
        Connection con = null;
        try {
            con = cm.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Books book = new Books();
                book.setUid(rs.getString("uid"));
                book.setTitle(rs.getString("title"));
                book.setPosition(rs.getString("position"));
                book.setIsbn(rs.getString("isbn"));

                Long authorId = rs.getLong("aid");
                Authors author = getAuthorById(con, authorId);
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

    private Authors getAuthorById(Connection con, Long authorId) throws SQLException {
        Authors author = null;
        PreparedStatement authorStatement = con.prepareStatement("SELECT * FROM authors WHERE aid = ?");
        authorStatement.setLong(1, authorId);
        ResultSet authorResult = authorStatement.executeQuery();

        if (authorResult.next()) {
            author = new Authors();
            author.setID(authorResult.getLong("aid"));
            author.setAuthor(authorResult.getString("author"));
        }
        return author;
    }

    @Override
    public List<Books> searchByTitleOrAuthor(String searchTerm) {
        List<Books> searchResults = new ArrayList<>();
        Connection con = null;
        try {
            con = cm.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM books WHERE title LIKE ? OR aid IN (SELECT id FROM authors WHERE author LIKE ?);");
            preparedStatement.setString(1, "%" + searchTerm + "%");
            preparedStatement.setString(2, "%" + searchTerm + "%");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setUid(rs.getString("uid"));
                book.setID(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setPosition(rs.getString("position"));
                book.setIsbn(rs.getString("isbn"));

                Long authorId = rs.getLong("aid");
                Authors author = getAuthorById(con, authorId);
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

}
