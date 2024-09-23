package school.hei.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBconnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/finalexam";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Kiady1508";

    @Bean
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection etablie");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
