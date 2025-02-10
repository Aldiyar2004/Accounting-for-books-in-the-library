package models;

import java.util.Date;

public class Borrower {
    private int id;
    private String name;
    private String email;
    private Date borrowDate;
    private Date returnDate;
    private int bookId;

    // Конструктор с id
    public Borrower(int id, String name, String email, Date borrowDate, Date returnDate, int bookId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookId = bookId;
    }

    // Конструктор без id (для создания новых объектов)
    public Borrower(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Borrower{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}











