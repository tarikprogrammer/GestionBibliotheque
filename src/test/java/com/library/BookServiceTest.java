package com.library;

import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {
    private BookService bookService;
    private BookDAO bookDAO;

    @BeforeEach
    void setUp() {
        bookDAO = new BookDAO();
        bookService = new BookService(bookDAO);
    }

    @Test
    void testAddBook() {
        Book book = new Book("Java Programming", "tarik belaid", "John Doe", 2020);
        book.setId(1);
        bookService.addBook(book);
        assertEquals(1, bookDAO.getAllBooks().size());
        assertEquals("Java Programming", bookDAO.getBookById(1).get().getTitle());
    }

    @Test
    void testUpdateBook() {
        /*Book book = new Book("Advanced Java", "tarik belaid", "John Doe", 2020);
        bookService.addBook(book);*/
        Book book = bookDAO.getBookById(1);
        book.setTitle("Advanced Java");
        book.setId(1);
        bookService.updateBook(book);
        assertEquals("Advanced Java", bookDAO.getBookById(1).getTitle());
        assertFalse(bookDAO.getBookById(1).get().isAvailable());
    }

   /* @Test
    void testDeleteBook() {
        bookService.deleteBook(1);
        System.out.println(String.valueOf(bookDAO.getBookById(1)).isEmpty());
        assertTrue(String.valueOf(bookDAO.getBookById(1)).isEmpty());
    }*/
}
