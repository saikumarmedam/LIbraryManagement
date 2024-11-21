import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/LibraryDB"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "Siri@5126"; 

    
    public static Connection getConnection() {
        try {
            
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
