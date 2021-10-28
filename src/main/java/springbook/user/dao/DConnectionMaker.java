package springbook.user.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@PropertySource("classpath:application.properties")
public class DConnectionMaker implements ConnectionMaker {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
