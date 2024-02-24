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
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);
    private static ConnectionManager instance;
    private List<Connection> connections;

    private final String JDBC_DRIVER = PropertyProvider.getProperty("JDBC_DRIVER");
    private final int POOL_SIZE = Integer.parseInt(PropertyProvider.getProperty("POOL_SIZE"));
    private final String JDBC_URL = PropertyProvider.getProperty("JDBC_URL");
    private final String DB_USER = PropertyProvider.getProperty("DB_USER");
    private final String DB_PASSWORD = PropertyProvider.getProperty("DB_PASSWORD");

    private ConnectionManager() {

        connections = new LinkedList<>();

        try {
            Class.forName(JDBC_DRIVER);
            for (int i = 0; i < POOL_SIZE; i++) {
                connections.add(DriverManager.getConnection(
                        JDBC_URL,
                        DB_USER,
                        DB_PASSWORD));
            }
        } catch (ClassNotFoundException e) {
            LOG.error("JDBC driver not found", e);
            throw new RepositoryException("Can not load JDBC Driver", e);
        } catch (SQLException e) {
            LOG.error("Could not connect to database", e);
            throw new RepositoryException("Can not create new connection", e);
        }
        LOG.info("Connection fully initialized");
    }

    public synchronized static ConnectionManager getInstance() {
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
