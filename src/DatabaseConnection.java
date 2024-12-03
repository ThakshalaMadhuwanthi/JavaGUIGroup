import java.sql.*;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gui"; // Database URL
    private static final String DATABASE_USER = "root";  // MySQL username
    private static final String DATABASE_PASSWORD = "Orange@456"; // MySQL password (blank here, but set to your password)

    public static Connection getConnection() throws SQLException {
        // Load the MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC Driver for MySQL version 8.x or above
        } catch (ClassNotFoundException e) {
            // This exception is thrown if the JDBC driver is not found
            System.err.println("MySQL JDBC Driver not found.");
            throw new SQLException("JDBC Driver not found", e);
        }

        // Establish and return the connection to the database
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
    }
}
