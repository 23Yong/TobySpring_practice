package springbook.user.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {
    @Value("${spring.datasource.url}")
    private String url;

    @Bean
    public UserDao userDao() {
        UserDao userDao = new UserDaoJdbc();
        ((UserDaoJdbc) userDao).setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }
    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl(url);
        dataSource.setUsername("spring");
        dataSource.setPassword("book");

        return dataSource;
    }
}


