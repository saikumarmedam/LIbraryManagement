import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    BookOperations.addBook(title, author, publisher, price);
                    break;
                case 2:
                   
                    BookOperations.viewBooks();
                    break;
                case 3:
                    
                    System.out.print("Enter book ID to update: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    author = scanner.nextLine();
                    System.out.print("Enter new publisher: ");
                    publisher = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();
                    BookOperations.updateBook(bookId, title, author, publisher, price);
                    break;
                case 4:
                    
                    System.out.print("Enter book ID to delete: ");
                    bookId = scanner.nextInt();
                    BookOperations.deleteBook(bookId);
                    break;
                case 5:
                    
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter member phone: ");
                    String phone = scanner.nextLine();
                    MemberOperations.addMember(name, email, phone);
                    break;
                case 6:
                    
                    MemberOperations.viewMembers();
                    break;
                case 7:
                    
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
