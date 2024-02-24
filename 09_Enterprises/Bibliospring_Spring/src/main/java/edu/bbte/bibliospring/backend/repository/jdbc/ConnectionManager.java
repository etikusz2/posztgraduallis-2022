package edu.bbte.bibliospring.backend.repository.jdbc;

import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.utile.PropertyProvider;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class ConnectionManager {

    private Logger LOG;
    private List<Connection> connections;
    private PropertyProvider propertyProvider;

    private String JDBC_DRIVER;
    private int POOL_SIZE;
    private String JDBC_URL;
    private String DB_USER;
    private String DB_PASSWORD;

    @Autowired
    public ConnectionManager() {

    }

    @Autowired
    public void initialize(Logger LOG, PropertyProvider propertyProvider) {
        this.LOG = LOG;
        this.propertyProvider = propertyProvider;

        this.JDBC_DRIVER = propertyProvider.getProperty("JDBC_DRIVER");
        this.POOL_SIZE = Integer.parseInt(propertyProvider.getProperty("POOL_SIZE"));
        this.JDBC_URL = propertyProvider.getProperty("JDBC_URL");
        this.DB_USER = propertyProvider.getProperty("DB_USER");
        this.DB_PASSWORD = propertyProvider.getProperty("DB_PASSWORD");

        initializeConnections();
    }

    private void initializeConnections() {
        connections = new LinkedList<>();

        try {
            Class.forName(JDBC_DRIVER);
            for (int i = 0; i < POOL_SIZE; i++) {
                connections.add(DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD));
            }
        } catch (ClassNotFoundException e) {
            LOG.error("JDBC driver not found", e);
            throw new RepositoryException("Can not load JDBC Driver", e);
        } catch (SQLException e) {
            LOG.error("Could not connect to the database", e);
            throw new RepositoryException("Can not create a new connection", e);
        }
        LOG.info("Connection fully initialized");
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
