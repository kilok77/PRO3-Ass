package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/slaughterhouse?currentSchema=slaughterhouse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    private static Connection connection;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to the database");
            }
        }
        return connection;
    }
}
