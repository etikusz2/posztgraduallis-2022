package edu.bbte.bibliospring.backend.utile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {

    private static Logger LOG = LoggerFactory.getLogger(PropertyProvider.class);
    private static Properties properties;
    static {
        properties = new Properties();
        try (InputStream is = PropertyProvider.class.getResourceAsStream("/bibliospring.properties")) {
            properties.load(is);
        } catch (IOException e){
            LOG.error("Can not load system configuration", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
