package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            String dbDriver = "com.mysql.jdbc.Driver";
            String dbURL = "jdbc:mysql:// localhost:3306/";
            /* Database name to access */
            String dbName = "chatdb";
            String dbUsername = "root";
            String dbPassword = "123456789";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL + dbName,
                    dbUsername,
                    dbPassword);
            connection = con;
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
            connection.close();
    }
}
