package models;

import java.math.BigDecimal;
import java.util.Date;

public class BorrowingHistory {
    private int id;
    private int bookId;
    private int borrowerId;
    private Date borrowedDate;
    private Date returnedDate;
    private BigDecimal lateFee;

    // Конструкторы
    public BorrowingHistory() {}

    public BorrowingHistory(int bookId, int borrowerId, Date borrowedDate) {
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowedDate = borrowedDate;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }
}
