package com.library.model;

import java.util.Date;

public class Borrow {
    private int id;
    private Student student;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

    // Constructor with id, student, book, borrowDate, and returnDate
    public Borrow(int id, Student student, Book book, Date borrowDate, Date returnDate) {
        this.id = id;
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Constructor without id (used for saving new entries)
    public Borrow(Student student, Book book, Date borrowDate, Date returnDate) {
        this.student = student;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", student=" + student +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public void setBook(Book book) {
        this.book = book;
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
}