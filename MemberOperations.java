
import java.sql.*;

public class MemberOperations {

    
    public static void addMember(String name, String email, String phone) {
        String query = "INSERT INTO Members (name, email, phone) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
           
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            
            int rowsAffected = statement.executeUpdate(); 
            if (rowsAffected > 0) {
                System.out.println("Member added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void viewMembers() {
        String query = "SELECT * FROM Members";
        
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
           
            while (resultSet.next()) {
                int id = resultSet.getInt("member_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
