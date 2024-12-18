package com.library.dao;

import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.Student;
import com.library.service.BookService;
import com.library.service.StudentService;
import com.library.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {

    public List<Borrow> getAllBorrows() {
        List<Borrow> borrows = new ArrayList<>();
        String query = "SELECT * FROM borrows";
        try (Connection connection = DbConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Assuming Student and Book are being fetched by their IDs (or use appropriate field mapping)
                int studentId = rs.getInt("member");
                int bookId = rs.getInt("book");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");

                // Fetch Student and Book by ID
                Student student = getStudentById(studentId);
                Book book = getBookById(bookId);

                Borrow borrow = new Borrow(
                        rs.getInt("id"),
                        student,
                        book,
                        borrowDate,
                        returnDate
                );
                borrows.add(borrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return borrows;
    }

    // Fetch student by ID (example method, adjust based on your data model)
    private Student getStudentById(int studentId) {
        StudentDAO studentDAO = new StudentDAO();
        return studentDAO.getStudentById(studentId);  // Example
    }

    // Fetch book by ID (example method, adjust based on your data model)
    private Book getBookById(int bookId) {
       BookDAO bookDAO = new BookDAO();
        // Implement this method to retrieve book from the database
        return bookDAO.getBookById(bookId);  // Example
    }

    public void addBorrow(Borrow borrow) {
        String query = "INSERT INTO borrows (member, book, borrow_date, return_date) VALUES (?, ?, ?, ?)";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, borrow.getStudent().getId());  // Assuming the student object has an ID field
            stmt.setInt(2, borrow.getBook().getId());     // Assuming the book object has an ID field
            stmt.setDate(3, new java.sql.Date(borrow.getBorrowDate().getTime()));
            stmt.setDate(4, new java.sql.Date(borrow.getReturnDate().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Borrow borrow) {
        // Insert logic (same as addBorrow, can be used for saving)
        addBorrow(borrow);
    }
}