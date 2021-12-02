import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = DatabaseConnection.getInstance();
        System.out.println(connection.isValid(1000));
    }
}
