package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.utile.PropertyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ConnectionManager {
    private static final Logger log = LoggerFactory.getLogger(ConnectionManager.class);
    private static ConnectionManager instance;
    private final List<Connection> connections;

    private ConnectionManager() {
        connections = new LinkedList<>();
        try {
            String jdbcDriver = PropertyProvider.getProperty("JDBC_DRIVER");
            Class.forName(jdbcDriver);
            int poolSize = Integer.parseInt(PropertyProvider.getProperty("POOL_SIZE"));
            for (int i = 0; i < poolSize; i++) {
                String jdbcUrl = PropertyProvider.getProperty("JDBC_URL");
                String dbUser = PropertyProvider.getProperty("DB_USER");
                String dbPassword = PropertyProvider.getProperty("DB_PASSWORD");
                connections.add(DriverManager.getConnection(
                        jdbcUrl,
                        dbUser,
                        dbPassword));
            }
        } catch (ClassNotFoundException e) {
            log.error("JDBC driver not found", e);
            throw new RepositoryException("Can not load JDBC Driver", e);
        } catch (SQLException e) {
            log.error("Could not connect to database", e);
            throw new RepositoryException("Can not create new connection", e);
        }
        log.info("Connection fully initialized");
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connections.size() > 0) {
            return connections.remove(0);
        } else {
            return null;
        }
    }

    public void returnConnection(Connection connection) {
        connections.add(connection);
    }
}
