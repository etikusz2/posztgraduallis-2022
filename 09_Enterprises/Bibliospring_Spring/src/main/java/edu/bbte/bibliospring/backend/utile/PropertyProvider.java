package edu.bbte.bibliospring.backend.utile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertyResolver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:/bibliospring.properties")
public class PropertyProvider {

    @Autowired
    private PropertyResolver propertyResolver;


    public String getProperty(String key) {
        return propertyResolver.getProperty(key);
    }
}
