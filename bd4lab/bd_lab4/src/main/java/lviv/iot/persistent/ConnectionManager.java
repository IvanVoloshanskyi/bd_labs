package lviv.iot.persistent;


import java.sql.*;

public class ConnectionManager {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "824472234";

    private static Connection connection = null;

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException exception) {
                System.out.println("SQLException: " + exception.getMessage());
                System.out.println("SQLState: " + exception.getSQLState());
                System.out.println("VendorError: " + exception.getErrorCode());
            }
        }
        return connection;
    }
}
