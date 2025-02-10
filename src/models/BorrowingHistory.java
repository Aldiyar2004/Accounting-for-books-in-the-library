package models;

import java.sql.Date;

public class BorrowingHistory {
    private int id;
    private int bookId;
    private int borrowerId;
    private Date borrowedDate;
    private Date returnedDate;

    public BorrowingHistory(int id, int bookId, int borrowerId, Date borrowedDate, Date returnedDate) {
        this.id = id;
        this.bookId = bookId;
        this.borrowerId = borrowerId;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Borrower ID: " + borrowerId + ", Borrowed Date: " + borrowedDate + ", Return Date: " + returnedDate;
    }
}




