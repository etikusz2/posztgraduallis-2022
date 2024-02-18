package edu.bbte.bibliospringspringdata.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanFactory {

    @Bean
    @Scope("prototype")
    public Logger createLogger() {
        return LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    }
}
