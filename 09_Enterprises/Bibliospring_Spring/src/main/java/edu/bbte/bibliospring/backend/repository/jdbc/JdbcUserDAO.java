package edu.bbte.bibliospring.backend.repository.jdbc;

        import edu.bbte.bibliospring.backend.model.User;
        import edu.bbte.bibliospring.backend.repository.RepositoryException;
        import edu.bbte.bibliospring.backend.repository.UserDAO;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Profile;
        import org.springframework.stereotype.Repository;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

@Repository
@Profile("jdbc")
public class JdbcUserDAO implements UserDAO {
    @Autowired
    private Logger LOG;

    @Autowired
    private ConnectionManager cm;

    @Override
    public User create(User user) throws RepositoryException {
        Connection con = null;
        try {
            con = cm.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO users(`uid`, `username`, `password`) VALUES(?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUid());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            user.setID(rs.getLong(1));
        } catch (SQLException e) {
            LOG.error("User creation failed", e);
            throw new RepositoryException("User registration failed", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return user;
    }

    @Override
    public void delete(Long id) throws RepositoryException {

    }

    @Override
    public User update(User entity) throws RepositoryException {
        return null;
    }

    @Override
    public User getByID(Long id) {
        Connection con = null;
        User user = null;
        try {
            con = cm.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT * FROM users WHERE id = ?;");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            rs.next();
            user = new User();
            user.setUid(rs.getString("uid"));
            user.setID(rs.getLong("id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));

        } catch (SQLException e) {
            LOG.error("User selection failed", e);
            throw new RepositoryException("User selection failed", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        Connection con = null;
        List<User> users = new ArrayList<>();

        try {
            con = cm.getConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getString("uid"));
                user.setID(rs.getLong("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                users.add(user);
            }
        } catch (SQLException e) {
            LOG.error("User selection failed", e);
            throw new RepositoryException("User selection failed", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return users;
    }

    @Override
    public User getByUserName(String userName) throws RepositoryException {
        Connection con = null;
        User user = null;
        try {
            con = cm.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM users WHERE username = ?");
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getString("uid"));
                user.setID(rs.getLong("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            LOG.error("User selection failed.", e);
            throw new RepositoryException("User selection failed.", e);
        } finally {
            if (con != null) {
                cm.returnConnection(con);
            }
        }
        return user;
    }
}