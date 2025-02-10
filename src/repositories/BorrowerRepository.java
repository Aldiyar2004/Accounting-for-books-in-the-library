package repositories;

import models.Borrower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowerRepository {

    private final Connection connection;

    public BorrowerRepository(Connection connection) {
        this.connection = connection;
    }

    // Получение всех заемщиков
    public List<Borrower> getAllBorrowers() throws SQLException {
        List<Borrower> borrowers = new ArrayList<>();
        String query = "SELECT * FROM borrowers";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Borrower borrower = new Borrower(
                        rs.getInt("id"),  // Передаем id
                        rs.getString("name"),
                        rs.getString("email"),
                        null, null,  // Если ты не хочешь работать с датами в этом конструкторе
                        0  // Если не используешь bookId, передай 0 или оставь в конструкторе
                );
                borrowers.add(borrower);
            }
        }
        return borrowers;
    }

    // Добавить заемщика
    public void addBorrower(Borrower borrower) throws SQLException {
        String query = "INSERT INTO borrowers (name, email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, borrower.getName());
            stmt.setString(2, borrower.getEmail());
            stmt.executeUpdate();
        }
    }

    // Метод для того, чтобы заемщик взял книгу
    public void borrowBook(int borrowerId, int bookId) throws SQLException {
        String query = "INSERT INTO borrowings (borrower_id, book_id, borrow_date) VALUES (?, ?, CURRENT_DATE)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, borrowerId);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
    }

    // Метод для того, чтобы заемщик вернул книгу
    public void returnBook(int borrowerId, int bookId) throws SQLException {
        String query = "DELETE FROM borrowings WHERE borrower_id = ? AND book_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, borrowerId);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
    }
}




