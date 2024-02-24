package edu.bbte.bibliospringjpa.repository.jpa;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class EntityManagerProvider {

    /*@Bean
    public EntityManager entityManager(ApplicationContext ctx) {
        return Persistence.createEntityManagerFactory("bibliospring").createEntityManager();
    }*/

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factory.setPersistenceXmlLocation("classpath*:META-INF/persistence.xml");
        factory.setDataSource(getDataSource());
        factory.setPackagesToScan("edu.bbte.bibliospringjpa.model");
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");

        dataSourceBuilder.url("jdbc:mysql://localhost:3306/bibliospring");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("MyPassword123#");
        return dataSourceBuilder.build();
    }

}