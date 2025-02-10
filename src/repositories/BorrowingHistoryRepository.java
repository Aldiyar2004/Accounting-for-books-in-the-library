package repositories;

import models.BorrowingHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowingHistoryRepository {

    private Connection connection;

    public BorrowingHistoryRepository(Connection connection) {
        this.connection = connection;
    }

    // Получение всех заимствований
    public List<BorrowingHistory> getAllBorrowingHistory() throws SQLException {
        List<BorrowingHistory> history = new ArrayList<>();
        String query = "SELECT * FROM borrowing_history";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                BorrowingHistory borrowingHistory = new BorrowingHistory(
                        rs.getInt("id"),
                        rs.getInt("book_id"),
                        rs.getInt("borrower_id"),
                        rs.getDate("borrowed_date"),
                        rs.getDate("returned_date")
                );
                history.add(borrowingHistory);
            }
        }
        return history;
    }

    // Добавление нового заимствования
    public void addBorrowing(int bookId, int borrowerId, Date borrowedDate) throws SQLException {
        String query = "INSERT INTO borrowing_history (book_id, borrower_id, borrowed_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, bookId);
            stmt.setInt(2, borrowerId);
            stmt.setDate(3, borrowedDate);
            stmt.executeUpdate();
        }
    }
}



