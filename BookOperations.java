
import java.sql.*;

public class BookOperations {

    
    public static void addBook(String title, String author, String publisher, double price) {
        String query = "INSERT INTO Books (title, author, publisher, price) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
           
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, publisher);
            statement.setDouble(4, price);
            
            int rowsAffected = statement.executeUpdate(); 
            if (rowsAffected > 0) {
                System.out.println("Book added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public static void viewBooks() {
        String query = "SELECT * FROM Books";
        
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            // Iterate through the result set and display book details
            while (resultSet.next()) {
                int id = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                double price = resultSet.getDouble("price");
                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Price: " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void updateBook(int bookId, String title, String author, String publisher, double price) {
        String query = "UPDATE Books SET title = ?, author = ?, publisher = ?, price = ? WHERE book_id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, publisher);
            statement.setDouble(4, price);
            statement.setInt(5, bookId);
            
            int rowsAffected = statement.executeUpdate(); 
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void deleteBook(int bookId) {
        String query = "DELETE FROM Books WHERE book_id = ?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, bookId);
            
            int rowsAffected = statement.executeUpdate(); // Execute the delete query
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


