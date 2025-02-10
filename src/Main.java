import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import repositories.BookRepository;
import repositories.BorrowerRepository;
import models.Book;
import models.Borrower;
import services.LibraryService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Установить соединение с базой данных
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library_d", "postgres", "0000")) {

            // Создать экземпляры репозиториев
            BookRepository bookRepository = new BookRepository(connection);
            BorrowerRepository borrowerRepository = new BorrowerRepository(connection);
            // Создаем экземпляр LibraryService, передавая в конструктор репозитории
            LibraryService libraryService = new LibraryService(bookRepository, borrowerRepository);

            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                // Меню
                System.out.println("Library Menu:");
                System.out.println("1. View all books");
                System.out.println("2. Add a book");
                System.out.println("3. Search books");
                System.out.println("4. View all borrowers");
                System.out.println("5. Add a borrower");
                System.out.println("6. Borrow a book");
                System.out.println("7. Return a book");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        // Просмотреть все книги
                        libraryService.viewAllBooks();
                        break;
                    case 2:
                        // Добавить книгу
                        System.out.println("Enter book title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter book author:");
                        String author = scanner.nextLine();
                        System.out.println("Enter book genre:");
                        String genre = scanner.nextLine();
                        System.out.println("Enter book price:");
                        double price = scanner.nextDouble();
                        System.out.println("Is the book available? (true/false):");
                        boolean available = scanner.nextBoolean();
                        libraryService.addBook(new Book(title, author, genre, price, available));
                        break;
                    case 3:
                        // Поиск книги
                        System.out.println("Enter search term:");
                        String searchTerm = scanner.nextLine();
                        libraryService.searchBooks(searchTerm);
                        break;
                    case 4:
                        // Просмотреть всех заемщиков
                        libraryService.viewAllBorrowers();
                        break;
                    case 5:
                        // Добавить заемщика
                        System.out.println("Enter borrower name:");
                        String borrowerName = scanner.nextLine();
                        System.out.println("Enter borrower email:");
                        String borrowerEmail = scanner.nextLine();
                        libraryService.addBorrower(new Borrower(borrowerName, borrowerEmail));
                        break;
                    case 6:
                        // Одолжить книгу
                        System.out.println("Enter borrower ID:");
                        int borrowerId = scanner.nextInt();
                        System.out.println("Enter book ID to borrow:");
                        int bookId = scanner.nextInt();
                        libraryService.borrowBook(borrowerId, bookId);
                        break;
                    case 7:
                        // Вернуть книгу
                        System.out.println("Enter borrower ID:");
                        int returnBorrowerId = scanner.nextInt();
                        System.out.println("Enter book ID to return:");
                        int returnBookId = scanner.nextInt();
                        libraryService.returnBook(returnBorrowerId, returnBookId);
                        break;
                    case 8:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}











