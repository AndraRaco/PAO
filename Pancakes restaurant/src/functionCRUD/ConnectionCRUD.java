package functionCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionCRUD {
    String host;
    String username;
    String password;
    Connection connection;
    Statement statement; // Create the java statement

    public ConnectionCRUD() {
        host = "jdbc:mysql://localhost:3306/restaurant";
        username = "root";
        password = "root_password";

        try {
            // Create mysql database connection
            connection = DriverManager.getConnection(host, username, password);
        } catch (SQLException throwable) {
            System.out.println(throwable.getMessage());
        }

        // Create the java statement
        try {
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void closeConnectionCRUD() {
        try {
            statement.close();
        } catch (SQLException throwables) {
            System.out.println("Statement couldn't be closed.");
            throwables.printStackTrace();
        }
    }
}
