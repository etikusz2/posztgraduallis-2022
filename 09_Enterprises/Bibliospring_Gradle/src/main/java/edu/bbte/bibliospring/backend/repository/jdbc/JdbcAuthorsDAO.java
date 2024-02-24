package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcAuthorsDAO implements AuthorsDAO {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcAuthorsDAO.class);

    private final ConnectionManager cm = ConnectionManager.getInstance();

    @Override
    public Authors create(Authors author) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO authors(`uid`,`author`) VALUES(?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getUid());
            preparedStatement.setString(2, author.getAuthor());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                author.setId(rs.getLong(1));
            }

            con.commit();
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException rollbackException) {
                    LOG.error("Rollback failed", rollbackException);
                }
            }
            LOG.error("Author creation failed", e);
            throw new RepositoryException("Author creation failed", e);
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
        return author;
    }


    @Override
    public void delete(Long id) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            PreparedStatement preparedStatement = con.prepareStatement(
                    "DELETE FROM authors WHERE aid = ?;");
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
            LOG.error("Author deletion failed", e);
            throw new RepositoryException("Author deletion failed", e);
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
    public Authors update(Authors author) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            con.setAutoCommit(false);

            PreparedStatement preparedStatement = con.prepareStatement(
                    "UPDATE authors SET author = ? WHERE aid = ?;");
            preparedStatement.setString(1, author.getAuthor());
            preparedStatement.setLong(2, author.getId());
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
            LOG.error("Author update failed", e);
            throw new RepositoryException("Author update failed", e);
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
        return author;
    }

    @Override
    public Authors getAuthorByName(String fullName) {
        Connection con = null;
        try {
            con = cm.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM authors WHERE author = ?;");
            preparedStatement.setString(1, fullName);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Authors author = new Authors();
                author.setId(rs.getLong("aid"));
                author.setAuthor(rs.getString("author"));
                return author;
            }
        } catch (SQLException e) {
            LOG.error("Error retrieving author by name", e);
            throw new RepositoryException("Error retrieving author by name", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return null;
    }

    @Override
    public Authors getByID(Long id) {
        Authors author = null;
        Connection con = null;
        try {
            con = cm.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM authors WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                author = new Authors();
                author.setId(rs.getLong("aid"));
                author.setAuthor(rs.getString("author"));
            }
        } catch (SQLException e) {
            LOG.error("Error reading author", e);
            throw new RepositoryException("Error reading author", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return author;
    }
}
