package com.example.config;

import com.example.dao.DataDao;
import com.example.dao.DataDaoHibernateImpl;
import com.example.domain.Artist;
import com.example.domain.Song;
import com.example.service.DataService;
import com.example.service.DataServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.example")
@PropertySource(value = "classpath:application.properties")
@EnableWebMvc
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("denis160797d");
        return dataSource;
    }

    private SessionFactory sessionFactory() {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.example");
        localSessionFactoryBean.setHibernateProperties(hibernateProperties());
        try {
            localSessionFactoryBean.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localSessionFactoryBean.getObject();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));

        return properties;
    }

    @Bean
    public DataDao<Song> songDao() {
        return new DataDaoHibernateImpl<Song>(this.sessionFactory(), Song.class);
    }

    @Bean
    public DataDao<Artist> artistDao() {
        return new DataDaoHibernateImpl<Artist>(this.sessionFactory(), Artist.class);
    }

    @Bean
    public DataService<Song> songService() {
        return new DataServiceImpl<Song>(this.songDao());
    }
    @Bean
    public DataService<Artist> artistService() {
        return new DataServiceImpl<Artist>(this.artistDao());
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory());
        return hibernateTransactionManager;
    }
}
