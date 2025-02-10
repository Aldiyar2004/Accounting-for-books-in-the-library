package services;

import models.Book;
import models.Borrower;
import repositories.BookRepository;
import repositories.BorrowerRepository;

import java.sql.SQLException;
import java.util.List;

public class LibraryService {

    private final BookRepository bookRepository;
    private final BorrowerRepository borrowerRepository;

    public LibraryService(BookRepository bookRepository, BorrowerRepository borrowerRepository) {
        this.bookRepository = bookRepository;
        this.borrowerRepository = borrowerRepository;
    }

    // Просмотр всех книг
    public void viewAllBooks() {
        try {
            List<Book> books = bookRepository.getAllBooks();
            books.forEach(book -> System.out.println(book));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Добавить книгу
    public void addBook(Book book) {
        try {
            bookRepository.addBook(book);
            System.out.println("Book added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Поиск книг
    public void searchBooks(String searchTerm) {
        try {
            List<Book> books = bookRepository.searchBooks(searchTerm);
            if (books.isEmpty()) {
                System.out.println("No books found.");
            } else {
                books.forEach(book -> System.out.println(book));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Просмотр всех заемщиков
    public void viewAllBorrowers() {
        try {
            List<Borrower> borrowers = borrowerRepository.getAllBorrowers();
            borrowers.forEach(borrower -> System.out.println(borrower));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Добавить заемщика
    public void addBorrower(Borrower borrower) {
        try {
            borrowerRepository.addBorrower(borrower);
            System.out.println("Borrower added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Одолжить книгу
    public void borrowBook(int borrowerId, int bookId) {
        try {
            borrowerRepository.borrowBook(borrowerId, bookId);
            System.out.println("Book borrowed successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Вернуть книгу
    public void returnBook(int borrowerId, int bookId) {
        try {
            borrowerRepository.returnBook(borrowerId, bookId);
            System.out.println("Book returned successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}













