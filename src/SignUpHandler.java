import java.sql.*;

public class SignUpHandler {
    public void signUp(String name, String email2, String gender, String birthday, String password) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        String insertQuery = "INSERT INTO User (Name, Email, Gender, Birthday, Password) VALUES (?, ?, ?, ?, ?)";
        var preparedStatement = connection.prepareStatement(insertQuery);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, email2);
        preparedStatement.setString(3, gender);
        preparedStatement.setString(4, birthday);
        preparedStatement.setString(5, password);

        preparedStatement.executeUpdate();

        connection.close();
    }
}

